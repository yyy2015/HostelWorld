/**
 * Created by yyy on 2017/3/28.
 */

var CheckReserveList = {
    init:function(){
        this.gridsFather = $("#check-reserve-list");
        this.lastGrid = $(".check-reserve-item").eq(0);
    },
    updateData:function(list){
        this.gridsFather.empty();
        var _this = this;
        $.each(list,function(i,reserve){
            var tempGrid = _this.lastGrid.clone(true);
            tempGrid.find(".reserver-name").eq(0).text(reserve.userName);
            tempGrid.find(".start").eq(0).text(reserve.startDate);
            tempGrid.find(".end").eq(0).text(reserve.endDate);
            tempGrid.find(".type").eq(0).text(reserve.room.type);
            tempGrid.find(".num").eq(0).text(reserve.roomNum);
            tempGrid.find(".address").eq(0).text(reserve.room.address);
            tempGrid.find(".payMoney").eq(0).text(reserve.payMoney);

            var modal = tempGrid.find(".checkModal").eq(0);
            var modalId = "checkModal"+i;
            modal.attr("id",modalId);

            //应对多人入住
            var myAdd = modal.find(".my-add-item").eq(0);
            myAdd.click(function(){
                var father = modal.find(".liver-list").eq(0);
                father.append(
                    '<div class="liver-item"> ' +
                    '<span class="modal-param">入住人姓名：</span> ' +
                    '<input type="text" name="livername" class="liver"> ' +
                    '<button class="add-minus glyphicon glyphicon-minus-sign minusLiver"></button>' +
                    '</div>');

                $(".minusLiver").click(function(){
                    $(this).parent(".liver-item").remove();
                })

            })

            var toCheck = tempGrid.find(".checkIn").eq(0);
            toCheck.attr("data-target","#"+modalId);

            var confirmCheck = tempGrid.find(".button-check-confirm").eq(0);

            confirmCheck.click(function(){
                var livers = "";
                $(".liver").each(function(){
                    livers =livers + $(this).val()+"~";
                })
                console.log(livers);

                $.get({
                    url:"/hostel/checkIn",
                    data:{
                        reserveId:reserve.id,
                        roomId:reserve.room.id,
                        roomNum:reserve.roomNum,
                        start:reserve.startDate,
                        end:reserve.endDate,
                        livers:livers
                    },
                    success:function(newList){
                        CheckReserveList.updateData(newList);
                    },
                    error:function(){
                        console.log("check in wrong!");
                    }
                })
            })


            _this.gridsFather.append(tempGrid);
        })

    }
}





