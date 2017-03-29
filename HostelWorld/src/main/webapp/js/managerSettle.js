/**
 * Created by yyy on 2017/3/29.
 */

var BillList = {
    init:function(){
        this.gridsFather = $("#settle-body-list");
        this.lastGrid = $(".settle-body-item").eq(0);
    },
    updateData:function(list){
        this.gridsFather.empty();
        var _this = this;
        $.each(list,function(i,bill){
            var tempGrid = _this.lastGrid.clone(true);
            tempGrid.find(".id").eq(0).text(bill.id);
            tempGrid.find(".hostelSel").eq(0).text(bill.hostel.hostelSeq);
            tempGrid.find(".hostelName").eq(0).text(bill.hostel.hostelName);
            tempGrid.find(".total").eq(0).text(bill.money);
            tempGrid.find(".toSettle").eq(0).text((bill.money*0.7).toFixed(1));

            var settle = tempGrid.find(".btn-settle").eq(0);
            settle.click(function(){
                $.get({
                    url:"/hostelManage/settle/"+bill.hostel.id,
                    success:function(newList){
                        BillList.updateData(newList);
                        window.location.replace(window.location.href);
                    },
                    error:function(){
                        console.log("settle wrong!");
                    }
                })
            })

            _this.gridsFather.append(tempGrid);
        })
    }
}

$(document).ready(
    function(){
        BillList.init();
        $.get({
            url:"/hostelManage/bill",
            success:function(newList){
                BillList.updateData(newList);
                $.get({
                    url:"/hostelManage/hostelAccount",
                    success:function(value){
                        $("#hostelAccount").text(value);
                    }
                })
            },
            error:function(){
                console.log("get bill list wrong!");
            }
        })
    }
)