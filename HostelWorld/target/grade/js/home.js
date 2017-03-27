/**
 * Created by yyy on 2017/3/27.
 */
var HostelList={
    init:function(){
        this.gridsFather = $("#hostel-list");
        this.lastGrid = $(".hostel-list-item").eq(0);
        this.clear = $("<div class='clearfix'></div>");
    },
    updateData:function(hostelList){
        this.gridsFather.empty();
        var _this = this;
        $.each(hostelList,function(i,hostel){
            var tempGrid = _this.lastGrid.clone(true);
            tempGrid.find(".hostelName").eq(0).text(hostel.hostelName);
            tempGrid.find(".address").eq(0).text(hostel.address);
            tempGrid.find(".description").eq(0).text(hostel.description);
            tempGrid.find(".host").eq(0).text(hostel.host);

            var detail = tempGrid.find(".detail").eq(0);
            detail.attr("href","/hostel/detail/"+hostel.id);

            _this.gridsFather.append(tempGrid);
        })
    }
}

$(document).ready(
    function(){
        HostelList.init();
        $.get({
            url:"/hostel/list",
            success:function(newList){
                HostelList.updateData(newList);
            },
            error:function(){
                console.log("get hostel list wrong!");
            }
        })
    }
)