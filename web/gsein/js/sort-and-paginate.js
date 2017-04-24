/**
 * Created by G.Seinfeld on 2017/4/20.
 * 实现排序和分页功能的请求
 */

/**
 应用脚本规则：
 引用脚本: JQuery脚本和JQuery的form插件脚本
 Form的ID: viewform
 显示数据的div的ID: listview
 分页按钮HTML属性: pageindex="1"
 排序按钮HTML属性: orderfield="employeeid desc";
 提效排序字段Input的ID,Name: orderField
 提交分页索引Input的ID,Name: pageIndex
 **/


$(document).ready(
    function () {

        var orderField = $("#orderField").val();//获取排序声明
        var orders = orderField.split(" ");//将排序声明分割为排序列和排序类型
        var orderColumn = orders[0]; //获取排序列
        var orderType = orders[1]; //获取排序类型：asc desc
        if(orderColumn!=""){
            $(".orderable[orderColumn="+orderColumn+"]").attr("orderType", orderType); //将排序类型赋值给对应的列
            if(orderType == "asc"){
                $(".orderable[orderColumn="+orderColumn+"]").find(".orderSign").addClass("fui-triangle-up-small");
            }else if(orderType == "desc"){
                $(".orderable[orderColumn="+orderColumn+"]").find(".orderSign").addClass("fui-triangle-down-small");
            }
        }


        $(".orderable").click(function () {
            $("#pageIndex").val('1'); //排序后设置为第1页
            var orderType = $(this).attr("orderType");
            if(orderType!=""){
                if(orderType=="asc"){
                    orderType="desc";
                }else if(orderType=="desc"){
                    orderType="asc";
                }
            }else{
                orderType="asc";
            }
            var orderValue = $(this).attr("orderColumn")+" "+orderType;
            $("#orderField").val(orderValue);//将排序声明赋给隐藏输入框
            $("#viewform").submit();
        });

        $(".pagination a").click(function () {
            var page = $("#pageIndex").val();
            var $li = $(this).parent();
            if($li.hasClass("previous")){
                page = (page-1>0?page-1:1);
            } else if($li.hasClass("next")) {
                var pageNum = $(".pagination li a").length-2;
                page = (page+1>pageNum?pageNum:page+1);
            } else{
                page = $(this).html();
            }
            $("#pageIndex").val(page);
            $("#viewform").submit();
        });


    }
);