/**
 * Created by yyy on 2017/3/29.
 */

var LiveList = {
    init:function(){
        this.gridsFather = $("#plan-body-list");
        this.lastGrid = $(".plan-body-item").eq(0);
    },
    updateData:function(list){
        this.gridsFather.empty();
        var _this = this;
        $.each(list,function(i,live){
            var tempGrid = _this.lastGrid.clone(true);
            tempGrid.find(".liverName").eq(0).text(live.liverList);
            tempGrid.find(".start").eq(0).text(live.start);
            tempGrid.find(".end").eq(0).text(live.end);
            tempGrid.find(".type").eq(0).text(live.room.type);
            tempGrid.find(".roomNum").eq(0).text(live.roomNum);
            tempGrid.find(".address").eq(0).text(live.room.address);

            var checkOut = tempGrid.find(".btn-checkOut").eq(0);
            checkOut.click(function(){
                $.get({
                    url:"/hostel/checkOut/"+live.id,
                    success:function(){
                        window.location.replace(window.location.href);
                    },
                    error:function(){
                        console.log("check out wrong!");
                    }
                })
            })

            _this.gridsFather.append(tempGrid);
        })
    }
}