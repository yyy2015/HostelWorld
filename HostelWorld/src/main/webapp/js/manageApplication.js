/**
 * Created by yyy on 2017/3/24.
 */

var ApplicationList={
    init:function(){
        this.gridsFather = $("#application-list");
        this.lastGrid = $('.application-list-item').eq(0);
        this.clear = $("<div class='clearfix'></div>");
    },
    updateData:function(appList){
        this.gridsFather.empty();
        var _this = this;
        $.each(appList,function(i,application){
            var tempGride = _this.lastGrid.clone(true);
            var hostelName = tempGride.find(".hostelName").eq(0);
            hostelName.text(application.hostelName);
            var bankAccount = tempGride.find(".bankAccount").eq(0);
            bankAccount.text(application.bankAccount);
            var description = tempGride.find(".description").eq(0);
            description.text(application.description);
            var host = tempGride.find(".host").eq(0);
            host.text(application.host);

            var approve = tempGride.find(".approve").eq(0);
            approve.addEventListener("click",function(){
                //todo
            })

            var refuse = tempGride.find(".refuse").eq(0);
            refuse.addEventListener("click",function(){
                // todo
            })
            _this.gridsFather.append(tempGride);

        })
    }
}
