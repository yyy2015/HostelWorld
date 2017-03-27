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
            var address = tempGride.find(".address").eq(0);
            address.text(application.address);
            var description = tempGride.find(".description").eq(0);
            description.text(application.description);
            var host = tempGride.find(".host").eq(0);
            host.text(application.host);

            var approve = tempGride.find(".approve").eq(0);
            approve.click(function(){
                $.get({
                    url:"/hostelManage/approve/"+application.id,
                    success:function(newList){
                        ApplicationList.updateData(newList);
                    },
                    error:function(){
                        console.log("approve wrong!");
                    }
                })
            })

            var refuse = tempGride.find(".refuse").eq(0);
            refuse.click(function(){
                $.get({
                    url:"/hostelManage/refuse/"+application.id,
                    success:function(newList){
                        ApplicationList.updateData(newList);
                    },
                    error:function(){
                        console.log("refuse wrong!");
                    }
                })
            })

            _this.gridsFather.append(tempGride);

        })
    }
}

$(document).ready(
    function(){
        ApplicationList.init();
        $.get({
            url:"/hostelManage/applicationList",
            success:function(newList){
                ApplicationList.updateData(newList);
            },
            error:function(){
                console.log("get hostel application list wrong!");
            }

        })
    }
)
