package gomokucontest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class GomokuContest extends javax.swing.JFrame {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GomokuContest.getInstance().setVisible(true);
            }

        });
    }
    
    private LinkedList<EngineConf> engines = new LinkedList<EngineConf>();
    public static GomokuContest instance;
    public Xoxopanel xoxopanel = null;
    public int n = 15;

    private GomokuContest() {
        initComponents();

        xoxopanel = new Xoxopanel(n);
        setIconImage(new ImageIcon(this.getClass().getResource("icon.png")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        add(xoxopanel, BorderLayout.CENTER);
        setSize(490, 400);
        loadEngine();
        for(int i=0;i<engines.size();i++){
            jComboBox1.addItem(engines.get(i));
            jComboBox3.addItem(engines.get(i));
        }
        if (jComboBox3.getItemCount()>1) jComboBox3.setSelectedIndex(1);
        xoxopanel.new_game();
        xoxopanel.play1_win = 0;
        xoxopanel.play2_win = 0;
        xoxopanel.play1 = jComboBox1.getSelectedItem().toString();
        xoxopanel.play2 = jComboBox3.getSelectedItem().toString();
        xoxopanel.games_count = Integer.parseInt(jTextField1.getText());
        jProgressBar1.setMaximum(xoxopanel.games_count);
        if (jComboBox1.getSelectedIndex()>0) xoxopanel.xoxo1=((EngineConf)jComboBox1.getSelectedItem()).createEngine();
        if (jComboBox3.getSelectedIndex()>0) xoxopanel.xoxo2=((EngineConf)jComboBox3.getSelectedItem()).createEngine();
        xoxopanel.start_game();
    }

    public static GomokuContest getInstance() {
        if (instance == null) {
            instance = new GomokuContest();
        }
        return instance;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
 always regenerated by the GomokuContest Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gomoku contest");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(160, 500));

        jButton3.setText("New game");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Player 1 (x):");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Человек" }));

        jLabel2.setText("Player 2 (o):");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Человек" }));

        jButton4.setText("Start game");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Match count:");

        jTextField1.setText("100");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0:0");

        jLabel4.setText("Score:");

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        xoxopanel.new_game();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        xoxopanel.play1_win = 0;
        xoxopanel.play2_win = 0;
        xoxopanel.play1 = jComboBox1.getSelectedItem().toString();
        xoxopanel.play2 = jComboBox3.getSelectedItem().toString();
        xoxopanel.games_count = Integer.parseInt(jTextField1.getText());
        jProgressBar1.setMaximum(xoxopanel.games_count);
        if (jComboBox1.getSelectedIndex()>0) xoxopanel.xoxo1=((EngineConf)jComboBox1.getSelectedItem()).createEngine();
        if (jComboBox3.getSelectedIndex()>0) xoxopanel.xoxo2=((EngineConf)jComboBox3.getSelectedItem()).createEngine();
        xoxopanel.start_game();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public JProgressBar get_jProgressBar1() {
        return jProgressBar1;
    }

    public void setshet(String s) {
        jLabel5.setText(s);
    }

    private void loadEngine() {
        loadModules(ADDONS_MODULES);
    }

    private static final File ADDONS_MODULES = new File(".");
    private static String FILE_PROTOCOL_PREFIX = "file:";

    public void loadModules(File MODULES_DIR) {
        //System.out.println("Загрузка алгоритмов из " + MODULES_DIR.getAbsolutePath());
        if (MODULES_DIR.isDirectory()) {
            for (File file : MODULES_DIR.listFiles()) {
                if (file.isDirectory()) {
                    loadModules(file);
                }
                boolean isAlg=false;
                if (file.getName().endsWith(".jar")){
                    String xml=file.getAbsolutePath().substring(0, file.getAbsolutePath().length()-file.getName().length())
                            +file.getName().substring(0, file.getName().length()-4)+".xml";
                    File xmlf=new File(xml);
                    isAlg=xmlf.exists();
                }else if (file.getName().endsWith(".class")){
                    String xml=file.getAbsolutePath().substring(0, file.getAbsolutePath().length()-file.getName().length())
                            +file.getName().substring(0, file.getName().length()-6)+".xml";
                    File xmlf=new File(xml);
                    isAlg=xmlf.exists();
                }
                if (isAlg) {
                    try {
                        addClassPathURL(FILE_PROTOCOL_PREFIX + file.getAbsolutePath());
                    } catch (Throwable ex) {
                        System.out.println("Ошибка при загрузке списка модулей: " + ex.getMessage());
                    }
                }
            }
        }
    }

    public static String getFileExtension(String f) {
        String ext = "";
        int i = f.lastIndexOf('.');
        if (i > 0 && i < f.length() - 1) {
            ext = f.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    private void addClassPathURL(String path) throws Throwable {
        // URL файла для добавления к classpath
        URL u = new URL(path);
        // достаем системный загрузчик классов
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        // используя механизм отражения,
        // достаем метод для добавления URL к classpath
        Class urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        // делаем метод доступным для вызова
        method.setAccessible(true);
        // вызываем метод системного загрузчика,
        // передавая в качестве параметра
        // URL файла для добавления к classpath
        method.invoke(urlClassLoader, new Object[]{u});
        // Добавляем в список загруженных модулей
        String filename=path.substring(5, path.length()-3)+"xml";
        File file=new File(filename);
        if (file.isFile()){
            engines.add(new EngineConf(file));
        }
    }
}