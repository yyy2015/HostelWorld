/**
 * Created by yyy on 2017/3/28.
 */

var ReserveList = {
    init:function(){
        this.gridsFather = $("#reserve-list");
        this.lastGrid = $(".reserve-item").eq(0);
    },
    updateDate:function(reserveList){
        this.gridsFather.empty();
        var _this = this;
        $.each(reserveList,function(i,reserve){
            var tempGrid = _this.lastGrid.clone(true);
            tempGrid.find(".hostelName").eq(0).text(reserve.hostelName);
            tempGrid.find(".start").eq(0).text(reserve.startDate);
            tempGrid.find(".end").eq(0).text(reserve.endDate);
            tempGrid.find(".type").eq(0).text(reserve.room.type);
            tempGrid.find(".num").eq(0).text(reserve.num);
            tempGrid.find(".address").eq(0).text(reserve.room.address);
            tempGrid.find(".payMoney").eq(0).text(reserve.payMoney);

            $("#confirmCancel").click(function(){
                $.get({
                    url:""
                })
            })

            _this.gridsFather.append(tempGrid);

        })
    }
}