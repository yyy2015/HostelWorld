/**
 * Created by yyy on 2017/3/28.
 */

var PlanList={
    init:function(){
        this.gridsFather = $("#plan-body-list");
        this.lastGrid = $(".plan-body-item").eq(0);
        this.clear = $("<div class='clearfix'></div>");
    },
    updateDate:function(planList){
        this.gridsFather.empty();
        var _this = this;
        $.each(planList,function(i,room){
            var tempGrid = _this.lastGrid.clone(true);
            tempGrid.find(".no").eq(0).text(room.id);
            tempGrid.find(".start").eq(0).text(room.startDate);
            tempGrid.find(".end").eq(0).text(room.endDate);
            tempGrid.find(".type").eq(0).text(room.type);
            tempGrid.find(".num").eq(0).text(room.num);
            tempGrid.find(".address").eq(0).text(room.address);
            tempGrid.find(".price").eq(0).text(room.price);

            _this.gridsFather.append(tempGrid);
        })
    }
}

