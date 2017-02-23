package algoritmogenetico;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

class Grafica extends ApplicationFrame{
    
    ArrayList <Double> grafica = new ArrayList <>();
    
    public Grafica(ArrayList grafica) {
        super("MejorFitness");
        this.grafica = grafica;
        setContentPane(createPanel());
        pack();
    }
    
    

    private ChartPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,450));
        return chartPanel;
    }
    
    private JFreeChart createChart (DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createLineChart("Mejores fitness", "Fitness", "Número de la generación",
                dataset, PlotOrientation.VERTICAL, false, false, false);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < grafica.size(); i++) {
            dataset.addValue(grafica.get(i), "", Integer.toString(i));
        }
        return dataset;
    }
    
    public void execute(){
        setVisible(true);
    }
    
}
