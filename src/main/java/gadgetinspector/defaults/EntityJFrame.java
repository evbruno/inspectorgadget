package gadgetinspector.defaults;

import gadgetinspector.AttributesSolver;
import gadgetinspector.Inspector;
import gadgetinspector.panels.EntityPanel;
import gadgetinspector.panels.WorkspacePanel;

import javax.swing.*;

public class EntityJFrame {

    private JFrame jFrame;
    public EntityJFrame(Object object, Inspector inspector, AttributesSolver attributesSolver) {
        jFrame = new JFrame();

        JTabbedPane tabPane = new JTabbedPane();
        EntityPanel entidadePanel = new EntityPanel(object, inspector, attributesSolver);
        tabPane.addTab("Entity", entidadePanel.getComponent());
        tabPane.addTab("Workspace", new WorkspacePanel(entidadePanel, inspector).getComponent());

        jFrame.add(tabPane);
        jFrame.setSize(600, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


    public JFrame getFrame() {
        return jFrame;
    }
}
