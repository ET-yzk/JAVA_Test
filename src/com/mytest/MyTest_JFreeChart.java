package com.mytest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class JFreeChartDemo {
    void test1() {
        DefaultPieDataset dpd = new DefaultPieDataset(); //建立一个默认的饼图

        dpd.setValue("管理人员", 25);  //输入数据
        dpd.setValue("市场人员", 25);
        dpd.setValue("开发人员", 45);
        dpd.setValue("其他人员", 10);

        JFreeChart chart = ChartFactory.createPieChart("某公司人员组织数据图", dpd, true, true, false);
        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL

        Font titleFont = new Font("黑体", Font.BOLD, 20);
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(titleFont);// 为标题设置上字体

        Font plotFont = new Font("宋体", Font.PLAIN, 16);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(plotFont); // 为饼图元素设置上字体

        Font LegendFont = new Font("楷体", Font.PLAIN, 18);
        LegendTitle legend = chart.getLegend(0);
        legend.setItemFont(LegendFont);// 为图例说明设置字体

        ChartFrame chartFrame = new ChartFrame("某公司人员组织数据图", chart);
        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
        chartFrame.pack(); //以合适的大小展现图形
        chartFrame.setVisible(true);//图形是否可见

        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {2}", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));// 显示百分比

    }

    void test2() {
        //     创建类别图（Category）数据对象
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(100, "上海", "苹果");
        dataset.addValue(100, "广州", "苹果");
        dataset.addValue(200, "北京", "梨子");
        dataset.addValue(200, "上海", "梨子");
        dataset.addValue(200, "广州", "梨子");
        dataset.addValue(300, "北京", "葡萄");
        dataset.addValue(300, "上海", "葡萄");
        dataset.addValue(300, "广州", "葡萄");
        dataset.addValue(400, "北京", "香蕉");
        dataset.addValue(400, "上海", "香蕉");
        dataset.addValue(400, "广州", "香蕉");
        dataset.addValue(500, "北京", "荔枝");
        dataset.addValue(500, "上海", "荔枝");
        dataset.addValue(500, "广州", "荔枝");

        JFreeChart chart = ChartFactory.createBarChart3D("水果产量图", "水果", "水果", dataset, PlotOrientation.VERTICAL, true, true, true);

        Font titleFont = new Font("黑体", Font.BOLD, 20);
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(titleFont);// 为标题设置上字体

//        Font plotFont = new Font("宋体", Font.PLAIN, 16);
//        PiePlot plot = (PiePlot) chart.getPlot();
//        plot.setLabelFont(plotFont); // 为饼图元素设置上字体

        Font LegendFont = new Font("楷体", Font.PLAIN, 18);
        LegendTitle legend = chart.getLegend(0);
        legend.setItemFont(LegendFont);// 为图例说明设置字体

        ChartFrame frame = new ChartFrame("水果产量图 ", chart, true);
        frame.pack();
        frame.setVisible(true);
    }
}

public class MyTest_JFreeChart {
    public static void main(String[] args) {
        JFreeChartDemo j = new JFreeChartDemo();
        j.test1();
        j.test2();
    }

}

