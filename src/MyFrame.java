import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame{
    private JPanel  myPanel;
    private JButton myButton;

    public MyFrame(int width, int height){
        super();
        this.setLayout(new BorderLayout()); //BorderLayout布局
        this.setVisible(true);
        this.setSize(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(screenWidth/2-width/2,screenHeight/2-height/2);
    }


    public static void main(String[] args){

        //新建窗体
        MyFrame form = new MyFrame(700,700);

        //菜单栏
        form.initMenus();

        //初始化panel
        form.initPanel(600,600);

        //主体 按钮 输入框
        form.initContent(); //TODO

        //注册事件
        form.initEvent();  //TODO

    }

    /**
     *  面板主要内容
     */
    private void initContent() {

    }

    /**
     * 添加事件
     */
    private void initEvent() {

    }

    /**
     * 菜单栏
     */
    private void initMenus() {
        //菜单栏
        JMenuBar jMenuBar = new JMenuBar();

        // 文件
        JMenu jMenu_file = new JMenu("文件(F)");
        jMenu_file.setMnemonic(KeyEvent.VK_F);
        List<JMenuItem> jMenu_file_Items = new ArrayList<JMenuItem>();
        jMenu_file_Items.add(mySetJmenuItem("打开(O)",KeyEvent.VK_O));
        jMenu_file_Items.add(mySetJmenuItem("保存(S)",KeyEvent.VK_S));
        jMenu_file_Items.add(mySetJmenuItem("关闭(C)",KeyEvent.VK_C));
        for (JMenuItem jmenuItem : jMenu_file_Items) {
            jMenu_file.add(jmenuItem);
        }
        jMenuBar.add(jMenu_file);


        //编辑
        JMenu jMenu_edit = new JMenu("编辑(E)");
            jMenu_edit.setMnemonic(KeyEvent.VK_E);
        List<JMenuItem> jMenu_edit_Items = new ArrayList<JMenuItem>();

        JMenuItem ctrl_Z = mySetJmenuItem("撤销(ctrl+Z)");
        jMenu_edit_Items.add(ctrl_Z);
        ctrl_Z.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));

        JMenuItem ctrl_Y = mySetJmenuItem("恢复撤销( ctrl + Y )");
        jMenu_edit_Items.add(ctrl_Y);
        ctrl_Y.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));

        JMenuItem ctrl_C = mySetJmenuItem("复制(Ctrl + C )");
        jMenu_edit_Items.add(ctrl_C);
        ctrl_C.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));

        JMenuItem ctrl_V = mySetJmenuItem("粘贴(Ctrl + V )");
        jMenu_edit_Items.add(ctrl_V);
        ctrl_V.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));

        for (JMenuItem jmenuItem : jMenu_edit_Items) {
            jMenu_edit.add(jmenuItem);
        }
        jMenuBar.add(jMenu_edit);

        //帮助
        JMenu jMenu_help = new JMenu("帮助(H)");
        jMenu_edit.setMnemonic(KeyEvent.VK_H);
        List<JMenuItem> jMenu_help_Items = new ArrayList<JMenuItem>();
        jMenu_help_Items.add(mySetJmenuItem("版本"));
        jMenu_help_Items.add(mySetJmenuItem("作者"));
        jMenu_help_Items.add(mySetJmenuItem("更新"));
        for (JMenuItem jmenuItem : jMenu_help_Items) {
            jMenu_help.add(jmenuItem);
        }
        jMenuBar.add(jMenu_help);
        this.setJMenuBar(jMenuBar);
    }



    /**
     * 自定义菜单栏①
     * @param name
     * @param KeyEvent_VA_char
     * @return
     */
    private JMenuItem mySetJmenuItem(String name, int KeyEvent_VA_char) {
        JMenuItem jMenuItem = new JMenuItem(name);
        jMenuItem.setMnemonic(KeyEvent_VA_char);
        return jMenuItem;
    }

    /**
     * 自定义菜单栏②
     * @param name ad s
     * @return sd
     */
    private JMenuItem mySetJmenuItem(String name) {
        return new JMenuItem(name);
    }

    /**
     *  初始化面板
     * @param width
     * @param height
     */
    private void initPanel(int width, int height){
        myPanel = new JPanel();
        myPanel.setSize(width,height);
        JTextArea jtextArea = new JTextArea();
        jtextArea.setBackground(Color.WHITE);
        jtextArea.setRows(58);
        jtextArea.setColumns(58);
        jtextArea.setLineWrap(true);
        jtextArea.setAutoscrolls(true);
        myPanel.add(jtextArea,BorderLayout.CENTER);
        myPanel.setAutoscrolls(true);
        this.setContentPane(myPanel);
    }
}
