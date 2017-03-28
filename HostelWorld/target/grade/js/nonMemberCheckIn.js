/**
 * Created by yyy on 2017/3/29.
 */

var NonMemberList = {
    init:function(){
        this.gridsFather = $("#plan-body-list");
        this.lastGrid = $(".plan-body-item").eq(0);
    },
    updateData:function(list){
        this.gridsFather.empty();
        var _this = this;
        $.each(list,function(i,room){
            var tempGrid = _this.lastGrid.clone(true);
            tempGrid.find(".no").eq(0).text(room.id);
            tempGrid.find(".start").eq(0).text(room.startDate);
            tempGrid.find(".end").eq(0).text(room.endDate);
            tempGrid.find(".type").eq(0).text(room.type);
            tempGrid.find(".num").eq(0).text(room.num);
            tempGrid.find(".address").eq(0).text(room.address);
            tempGrid.find(".price").eq(0).text(room.price);

            //日期
            $('.my-date-picker').datetimepicker({
                format: 'yyyy-MM-dd hh:mm:ss',
                language: 'en',
                pickDate: true,
                pickTime: true,
                hourStep: 1,
                minuteStep: 15,
                secondStep: 30,
                inputMask: true
            })

            //模态框
            var modal = tempGrid.find(".checkModal").eq(0);
            var modalId = "nonMemberCheck"+i;
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

            var toCheck = tempGrid.find(".notMemberCheck").eq(0);
            toCheck.attr("data-target","#"+modalId);

            var confirmCheck = tempGrid.find(".button-check-confirm").eq(0);

            confirmCheck.click(function(){
                //livers
                var livers = "";
                tempGrid.find(".liver").each(function(){
                    console.log($(this).val());
                    livers = livers + $(this).val()+"~";
                })
                console.log(livers);

                //roomNum,start,end
                var roomNum = tempGrid.find(".roomNum").eq(0).val();
                var startDate = tempGrid.find(".startDate").eq(0).val();
                var endDate = tempGrid.find(".endDate").eq(0).val();


                $.get({
                    url:"/hostel/nonMemberCheckIn",
                    data:{
                        roomId:room.id,
                        roomNum:roomNum,
                        start:startDate,
                        end:endDate,
                        livers:livers
                    },
                    success:function(){
                        window.location.replace(window.location.href);
                    },
                    error:function(){
                        console.log("nonMemberCheckIn wrong!");
                    }
                })

            })

            _this.gridsFather.append(tempGrid);

            $('.my-date-picker').datetimepicker({
                format: 'yyyy-MM-dd hh:mm:ss',
                language: 'en',
                pickDate: true,
                pickTime: true,
                hourStep: 1,
                minuteStep: 15,
                secondStep: 30,
                inputMask: true
            })

        })
    }
}