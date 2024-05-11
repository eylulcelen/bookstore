package dnm2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

//adds border to rows and columns
public class CustomTableCellRenderer extends DefaultTableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
        } else {
            c.setBackground(Color.WHITE);
        }

        if (c instanceof JComponent) {
            ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));
        }

        return c;
    }
}