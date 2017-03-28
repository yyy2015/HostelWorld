/**
 * Created by yyy on 2017/3/29.
 */

$(document).ready(
    function(){
        $.get({
            url:"/statistic/hostelMoney",
            success:function(data){
                Highcharts.chart('hostel-money', {
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title: {
                        text: 'Hostel World各客栈盈利百分比饼图'
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                style: {
                                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                }
                            }
                        }
                    },
                    series: [{
                        name: 'Brands',
                        colorByPoint: true,
                        data: data
                    }]
                });
            }
        })

        $.get({
            url:"/statistic/hostelMoneyBar",
            success:function(data){
                Highcharts.chart('hostel-money-bar', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'HostelWorld各个客栈收益总额'
                    },
                    xAxis: {
                        type: 'category'
                    },
                    yAxis: {
                        title: {
                            text: 'Total money'
                        }

                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        series: {
                            borderWidth: 0,
                            dataLabels: {
                                enabled: true
                            }
                        }
                    },

                    tooltip: {
                        headerFormat: '<span style="font-size:11px">{series.name}</span><br>'
                    },

                    series: [{
                        name: '总收益',
                        colorByPoint: true,
                        data: data
                    }]

                });
            }
        })

        $.get({
            url:"/statistic/hostelNames",
            success:function(catagory){
                $.get({
                    url:"/statistic/getReserveStat",
                    success:function(data){
                        Highcharts.chart('hostel-money-res', {
                            chart: {
                                type: 'column'
                            },
                            title: {
                                text: '各客栈预订情况统计'
                            },
                            xAxis: {
                                categories: catagory
                            },
                            credits: {
                                enabled: false
                            },
                            series: data
                        });
                    }
                })
            }
        })
    }
)


