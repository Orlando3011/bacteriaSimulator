package pl.psk.bacteriaSimulator.service;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PlotService {
    private final String chartPath = System.getProperty("user.home") + "\\Downloads\\chart.png";

    public JFreeChart createXYPlot(List<Long> values) {
        final XYSeries series = new XYSeries("population");
        int counter  = 1;
        for (Long value:values) {
            series.add(counter, value);
            counter++;
        }

        final XYSeriesCollection data = new XYSeriesCollection(series);
        return ChartFactory.createXYLineChart(
                "Liczebność populacji",
                "Pokolenie",
                "Liczebność",
                data,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
    }

    public void savePlotAsPng(JFreeChart chart) throws IOException {
        File file = new File(chartPath);
        ChartUtils.saveChartAsPNG(file, chart, 500, 500);
    }
}
