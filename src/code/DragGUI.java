package code;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;

import javax.activation.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;
/**
 * The DragGUI class takes care of all the graphical functionality of the UB Conquest game.
 
 * @author Patrick,Chris,Dom,Rafael
 *
 */

public class DragGUI {
	private GameDriver _gd;
	private JFrame _f;
	private DragPanel[] Art;
    private DragPanel[] Science;
    private DragPanel[] Law;
    private DragPanel[] Humanities;
    private DragPanel[] Medicine;
    private DragPanel[] Engineering;
	
	public DragGUI(){
	    _f = new JFrame();
	}
	/**
	 * updateUI()
	 * 
	 * Updates the GUI every time some displayed value changes.
	 */
	
	public void updateUI(){
		_gd.foundEliminated();
		
			
		MouseListener handler = new Handler();
		LabelTransferHandler th = new LabelTransferHandler(this, true);// handler for moving old students to new depts
		LabelTransferHandler th2 = new LabelTransferHandler(this, false); //handler for adding new students
	    Art = new DragPanel[4];
	    Science = new DragPanel[4];
	    Law = new DragPanel[4];
	    Humanities = new DragPanel[4];
	    Medicine = new DragPanel[4];
	    Engineering = new DragPanel[4];
	    Art[0] = new DragPanel(_gd.getGameBoard().getArts().getDepts()[0]);
    	Science[0] = new DragPanel(_gd.getGameBoard().getSciences().getDepts()[0]);
    	Law[0] = new DragPanel(_gd.getGameBoard().getLaw().getDepts()[0]);
    	Humanities[0] = new DragPanel(_gd.getGameBoard().getHumanities().getDepts()[0]);
    	Medicine[0] = new DragPanel(_gd.getGameBoard().getMedicine().getDepts()[0]);
    	Engineering[0] = new DragPanel(_gd.getGameBoard().getEngineering().getDepts()[0]);
    	Art[1] = new DragPanel(_gd.getGameBoard().getArts().getDepts()[1]);
    	Science[1] = new DragPanel(_gd.getGameBoard().getSciences().getDepts()[1]);
    	Law[1] = new DragPanel(_gd.getGameBoard().getLaw().getDepts()[1]);
    	Humanities[1] = new DragPanel(_gd.getGameBoard().getHumanities().getDepts()[1]);
    	Medicine[1] = new DragPanel(_gd.getGameBoard().getMedicine().getDepts()[1]);
    	Engineering[1] = new DragPanel(_gd.getGameBoard().getEngineering().getDepts()[1]);
    	Art[2] = new DragPanel(_gd.getGameBoard().getArts().getDepts()[2]);
    	Science[2] = new DragPanel(_gd.getGameBoard().getSciences().getDepts()[2]);
    	Law[2] = new DragPanel(_gd.getGameBoard().getLaw().getDepts()[2]);
    	Humanities[2] = new DragPanel(_gd.getGameBoard().getHumanities().getDepts()[2]);
    	Medicine[2] = new DragPanel(_gd.getGameBoard().getMedicine().getDepts()[2]);
    	Engineering[2] = new DragPanel(_gd.getGameBoard().getEngineering().getDepts()[2]);
    	Art[3] = new DragPanel(_gd.getGameBoard().getArts().getDepts()[3]);
    	Science[3] = new DragPanel(_gd.getGameBoard().getSciences().getDepts()[3]);
    	Law[3] = new DragPanel(_gd.getGameBoard().getLaw().getDepts()[3]);
    	Humanities[3] = new DragPanel(_gd.getGameBoard().getHumanities().getDepts()[3]);
    	Medicine[3] = new DragPanel(_gd.getGameBoard().getMedicine().getDepts()[3]);
    	Engineering[3] = new DragPanel(_gd.getGameBoard().getEngineering().getDepts()[3]);
	    for(int i = 0; i < 4; i++){
	    	Art[i].addMouseListener(handler);
	    	Art[i].setTransferHandler(th);
	    	Art[i].setBackground(Color.PINK);
	    	if (Art[i].getDept().equals(_gd.getGameBoard().getArts().getDepts()[0])){
	    		Art[i].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
	    	}
	    	else if (Art[i].getDept().equals(_gd.getGameBoard().getArts().getDepts()[3])) {
	    		Art[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    	}
	    	else {
	    		Art[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	}
	    	Science[i].addMouseListener(handler);
	    	Science[i].setTransferHandler(th);
	    	Science[i].setBackground(Color.GREEN);
	    	if (Science[i].getDept().equals(_gd.getGameBoard().getSciences().getDepts()[2])){
	    		Science[i].setBorder(BorderFactory.createLineBorder(Color.ORANGE));
	    	}
	    	else if (Science[i].getDept().equals(_gd.getGameBoard().getSciences().getDepts()[3])) {
	    		Science[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
	    	}
	    	else if (Science[i].getDept().equals(_gd.getGameBoard().getSciences().getDepts()[1])) {
	    		Science[i].setBorder(BorderFactory.createLineBorder(Color.RED));
	    	}
	    	else {
	    		Science[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	}
	    	Law[i].addMouseListener(handler);
	    	Law[i].setTransferHandler(th);
	    	Law[i].setBackground(Color.ORANGE);
	    	if (Law[i].getDept().equals(_gd.getGameBoard().getLaw().getDepts()[0])) {
		    	Law[i].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
	    	}
	    	else if (Law[i].getDept().equals(_gd.getGameBoard().getLaw().getDepts()[2])){
	    		Law[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
	    	}
	    	else {
		    	Law[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	}
	    	Humanities[i].addMouseListener(handler);
	    	Humanities[i].setTransferHandler(th);
	    	Humanities[i].setBackground(Color.RED);
	    	if (Humanities[i].getDept().equals(_gd.getGameBoard().getHumanities().getDepts()[1])){
	    		Humanities[i].setBorder(BorderFactory.createLineBorder(Color.GREEN));
	    	}
	    	else if (Humanities[i].getDept().equals(_gd.getGameBoard().getHumanities().getDepts()[3])) {
	    		Humanities[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
	    	}
	    	else {
	    		Humanities[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	}
	    	Medicine[i].addMouseListener(handler);
	    	Medicine[i].setTransferHandler(th);
	    	Medicine[i].setBackground(Color.BLUE);
	    	if (Medicine[i].getDept().equals(_gd.getGameBoard().getMedicine().getDepts()[0])) {
	    		Medicine[i].setBorder(BorderFactory.createLineBorder(Color.RED));
	    	}
	    	else if (Medicine[i].getDept().equals(_gd.getGameBoard().getMedicine().getDepts()[2])) {
	    		Medicine[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
	    	}
	    	else {
		    	Medicine[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	}
	    	Engineering[i].addMouseListener(handler);
	    	Engineering[i].setTransferHandler(th);
	    	Engineering[i].setBackground(Color.YELLOW);
	    	if (Engineering[i].getDept().equals(_gd.getGameBoard().getEngineering().getDepts()[2])) {
	    		Engineering[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    	}
	    	else if (Engineering[i].getDept().equals(_gd.getGameBoard().getEngineering().getDepts()[0])) {
	    		Engineering[i].setBorder(BorderFactory.createLineBorder(Color.GREEN));
	    	}
	    	else if (Engineering[i].getDept().equals(_gd.getGameBoard().getEngineering().getDepts()[3])) {
	    		Engineering[i].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
	    	}
	    	else {
	    		Engineering[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	}
	    }
	    
	    Art[0].add(makeHoverLabel(Art[0].getDept()));
	    Art[1].add(makeHoverLabel(Art[1].getDept())); 
	    Art[2].add(makeHoverLabel(Art[2].getDept()));
	    Art[3].add(makeHoverLabel(Art[3].getDept()));
	    
	    Science[0].add(makeHoverLabel(Science[0].getDept()));
	    Science[1].add(makeHoverLabel(Science[1].getDept())); 
	    Science[2].add(makeHoverLabel(Science[2].getDept()));
	    Science[3].add(makeHoverLabel(Science[3].getDept()));
	    
	    Humanities[0].add(makeHoverLabel(Humanities[0].getDept()));
	    Humanities[1].add(makeHoverLabel(Humanities[1].getDept())); 
	    Humanities[2].add(makeHoverLabel(Humanities[2].getDept()));
	    Humanities[3].add(makeHoverLabel(Humanities[3].getDept()));
	    
	    Engineering[0].add(makeHoverLabel(Engineering[0].getDept()));
	    Engineering[1].add(makeHoverLabel(Engineering[1].getDept())); 
	    Engineering[2].add(makeHoverLabel(Engineering[2].getDept()));
	    Engineering[3].add(makeHoverLabel(Engineering[3].getDept()));
	    
	    Law[0].add(makeHoverLabel(Law[0].getDept()));
	    Law[1].add(makeHoverLabel(Law[1].getDept())); 
	    Law[2].add(makeHoverLabel(Law[2].getDept()));
	    Law[3].add(makeHoverLabel(Law[3].getDept()));
	    
	    Medicine[0].add(makeHoverLabel(Medicine[0].getDept()));
	    Medicine[1].add(makeHoverLabel(Medicine[1].getDept())); 
	    Medicine[2].add(makeHoverLabel(Medicine[2].getDept()));
	    Medicine[3].add(makeHoverLabel(Medicine[3].getDept()));
	    
	    for(int i = 0; i<4 ; i ++){
	    	Art[i].add(new JLabel("St x " + _gd.getCurrentPlayer().getMovableInDept(Art[i].getDept())));
	        Science[i].add(new JLabel("St x " + _gd.getCurrentPlayer().getMovableInDept(Science[i].getDept())));
	        Humanities[i].add(new JLabel("St x " + _gd.getCurrentPlayer().getMovableInDept(Humanities[i].getDept())));
	        Engineering[i].add(new JLabel("St x " + _gd.getCurrentPlayer().getMovableInDept(Engineering[i].getDept())));
	        Law[i].add(new JLabel("St x " + _gd.getCurrentPlayer().getMovableInDept(Law[i].getDept())));
	        Medicine[i].add(new JLabel("St x " + _gd.getCurrentPlayer().getMovableInDept(Medicine[i].getDept())));
	    }
	    
	    JPanel A = new JPanel();
	    A.add(setDragGUI(Art,_gd.getGameBoard().getArts()));
	    
	    JPanel S = new JPanel();
	    S.add(setDragGUI(Science,_gd.getGameBoard().getSciences()));
	    
	    JPanel L = new JPanel();
	    L.add(setDragGUI(Law,_gd.getGameBoard().getLaw()));
	    
	    JPanel H = new JPanel();
	    H.add(setDragGUI(Humanities,_gd.getGameBoard().getHumanities()));
	    
	    JPanel M = new JPanel();
	    M.add(setDragGUI(Medicine,_gd.getGameBoard().getMedicine()));
	    
	    JPanel E = new JPanel();
	    E.add(setDragGUI(Engineering,_gd.getGameBoard().getEngineering()));
	    
	    JPanel all = new JPanel(new GridLayout(2,2));
	    //Code to rearrange things on GUI

	   //-----------------------

	    all.add(A);
	    all.add(S);
	    all.add(L);
	    all.add(H);
	    all.add(M);
	    all.add(E);
	    //-------------- this is the order in which the schools appear
	    JPanel buttonjl = new JPanel(new GridLayout(2,4));
	    DragPanel dp = new DragPanel(new Dept("drag"));
	    dp.addMouseListener(handler);
		dp.setTransferHandler(th2);
		
		

		JLabel pic = new JLabel();
	    pic.setIcon(new ImageIcon(loadImage("/images/Player Picture.png")));
	    dp.add(pic);
	    dp.validate();
	    //-------------------------------
	    
	    
	    buttonjl.add(dp);
	    buttonjl.add(new JLabel("Current Player: \n" + _gd.getCurrentPlayer().getName()));
	    buttonjl.add(new JLabel("Students to place x " + _gd.getCurrentPlayer().getOnhand()));
	    JButton jb = new JButton("End Turn");
	    jb.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e) {
	        	_gd.nextTurn();
	            updateUI();
	        }
	    });
	    
	    buttonjl.add(jb);
	    JButton electionButton = new JButton("Call Election");
	    electionButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Dept[] depts = _gd.getGameBoard().getDepts();
	    		String dept = JOptionPane.showInputDialog("Which Department would you like to call an election in?");
	    		Dept d = null;
	    		for (int i = 0; i < depts.length; i++) {
	    			if (dept.equals(depts[i].getName())) {
	    				d = depts[i];
	    			}
	    		}
	    		while (d == null) {
	    			dept = JOptionPane.showInputDialog("That is not a valid Department name. Please enter a valid Department name.");
	    			System.out.println(dept);
	    			for (int j = 0; j < depts.length; j++) {
	    				if (dept.equals(depts[j].getName())) {
	    					d = depts[j];
	    				}
	    			}
	    		}
	    		_gd.wonElection(_gd.getCurrentPlayer(), d);
	    		updateUI();
	    	}
	    });
	    
	    JLabel chairsOfCurrentPlayer = new JLabel();
	    ArrayList<Dept> depts = _gd.getCurrentPlayer().getChairs();
	    ArrayList<String> chairs = new ArrayList<String>();
	    for(Dept dept: depts){
	    	chairs.add(dept.getName());
	    }
	    
	    String chairText = "";
	    for(int i = 0; i < chairs.size(); i++){
	    	if(i == chairs.size() - 1){
	    		chairText = chairText + chairs.get(i);
	    	}
	    	else{
	    		chairText = chairText + chairs.get(i) + ", ";
	    	}
	    }
    	chairsOfCurrentPlayer.setText(chairText);
	    JPanel placeholder = new JPanel(new GridLayout(2,6));
	    JLabel chairsTitle = new JLabel("You are currently chair of: ");
	    
	 
	    JScrollPane scroller = new JScrollPane(chairsOfCurrentPlayer);
	    
	    placeholder.add(chairsTitle);
	    placeholder.add(scroller);
	    placeholder.add(electionButton);
	    all.add(buttonjl);
	    all.add(placeholder);
	    
	    //-------------------------------- lower right hand with dragging label and button
	    
	    GridLayout g = new GridLayout();
	    
	    JPanel panel = new JPanel(g);
	    //panel.add(new JPanel());
	    panel.add(all);
	    
	    _f.getContentPane().removeAll();
	    _f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    _f.getContentPane().add(panel);
	    Toolkit kit = Toolkit.getDefaultToolkit();  
	    int x = ((int)kit.getScreenSize().getWidth());  
	    int y = ((int)kit.getScreenSize().getHeight());  
	    _f.setSize(x,y); 
	    _f.setVisible(true);   
	}
	
	
	/**
	 * loadImage(String fileName)
	 * 
	 * Prepares and returns a BufferedImage based on its file name.
	 * @param fileName (file name)
	 * @return buff (the buffered image)
	 */
	 public BufferedImage loadImage(String fileName){
		  BufferedImage buff = null;
		  try{
			  buff = ImageIO.read(getClass().getResourceAsStream(fileName));
		  }
		  catch(IOException e){
			  e.printStackTrace();
			  return null;
		  }
		  return buff;
	  }
	 
	/**
	 * getDeptFromPanel(DragPanel d)
	 * 
	 * Returns the Dept of a given DragPanel.
	 * @param d (the Dragpanel)
	 * @return (the Dept of d)
	 */
	public Dept getDeptFromPanel(DragPanel d){
		return d.getDept();	
	}
	/**
	 * makeHover(Dept d)
	 * 
	 * Creates a tool tip text that stores the Current Players students in the department and every other players.
	 * @param d (the given department)
	 * @return temp (a JLabel that contains the "hoverlabel")
	 */
	public JLabel makeHoverLabel(Dept d){
		JLabel temp = new JLabel();
		temp.setIcon(new ImageIcon(loadImage("/images/Info.png")));
	    temp.setToolTipText("Current Player's Students: " + _gd.getCurrentPlayer().countInDept(d) + "      Everyone Else's Players: " + _gd.everyoneElsesStudents(d));
	    return temp;
	}
	
	/**
	 * getGameDriver()
	 * 
	 * Accessor method for the GameDriver.
	 * @return _gd (the GameDriver)
	 */
	
	public GameDriver getGameDriver(){
		return _gd;
	}
	/**
	 * setGameDriver(GameDriver gd)
	 * 
	 * Sets the DragGUI's GameDriver to another GameDriver.
	 * @param gd (the GameDriver that is going to be set)
	 */
	
	public void setGameDriver(GameDriver gd){
		_gd = gd;
	}
    
	/**
	 * setDragGUI(DragPanel[] d, School sc)
	 * 
	 * Sets up a JPanel for each individual School using inputed DragPanels.
	 * @param d (an array of DragPanels)
	 * @param sc (the school that the DragPanels with belong to)
	 * @return temp (the finished GUI JPanel)
	 */
	
  public JPanel setDragGUI(DragPanel[] d,School sc){
	  //System.out.println(sc.getDepts()[0].getName());
	  GridLayout g = new GridLayout(2,6);
	  JPanel temp = new JPanel(g);
	  JLabel temp1 = new JLabel(sc.getDepts()[0].getName());
	  if (_gd.getCurrentPlayer().equals(sc.getDepts()[0].getChair())) {temp1.setForeground(Color.GREEN);}
	  else if (sc.getDepts()[0].getChair().getName().equals("no chair")) {temp1.setForeground(Color.BLACK);}
	  else {temp1.setForeground(Color.RED);}
	  temp1.setToolTipText("Current Chair: " + sc.getDepts()[0].getChair().getName());
	  temp.add(temp1);
	  temp.add(d[0]);
	  temp.add(d[1]);
	  temp1 = new JLabel(sc.getDepts()[1].getName());
	  if (_gd.getCurrentPlayer().equals(sc.getDepts()[1].getChair())) {temp1.setForeground(Color.GREEN);}
	  else if (sc.getDepts()[1].getChair().getName().equals("no chair")) {temp1.setForeground(Color.BLACK);}
	  else {temp1.setForeground(Color.RED);}
	  temp1.setToolTipText("Current Chair: " + sc.getDepts()[1].getChair().getName());
	  temp.add(temp1);
	  temp1 = new JLabel(sc.getDepts()[2].getName());
	  if (_gd.getCurrentPlayer().equals(sc.getDepts()[2].getChair())) {temp1.setForeground(Color.GREEN);}
	  else if (sc.getDepts()[2].getChair().getName().equals("no chair")) {temp1.setForeground(Color.BLACK);}
	  else {temp1.setForeground(Color.RED);}
	  temp1.setToolTipText("Current Chair: " + sc.getDepts()[2].getChair().getName());
	  temp.add(temp1);
	  temp.add(d[2]);
	  temp.add(d[3]);
	  temp1 = new JLabel(sc.getDepts()[3].getName());
	  if (_gd.getCurrentPlayer().equals(sc.getDepts()[3].getChair())) {temp1.setForeground(Color.GREEN);}
	  else if (sc.getDepts()[3].getChair().getName().equals("no chair")) {temp1.setForeground(Color.BLACK);}
	  else {temp1.setForeground(Color.RED);}
	  temp1.setToolTipText("Current Chair: " + sc.getDepts()[3].getChair().getName());
	  temp.add(temp1);
	  return temp;
  }
}




/**
 * DragPanel extends JPanel and acts as a holder for JLabels that can moved using the LabelTransferListener class.
 * @author Patrick,Dom,Chris,Rafael
 */


class DragPanel extends JPanel {
	private Dept _dept;
  public DragPanel(Dept d) {
	_dept = d;
  }
  /**
   * getDept()
   * 
   * Accessor method for the dept.
   * @return _dept (the department stored in the DragPanel)
   */
  public Dept getDept(){
	  return _dept;
  }
  public JLabel draggingLabel;
}





/**
 * MouseAdapter is an action listener that allows the JLabels to be moved based on input from a mouse device.
 * @author Patrick, Dom,Chris,Rafael
 *
 */
class Handler extends MouseAdapter {
  @Override public void mousePressed(MouseEvent e) {
    DragPanel p = (DragPanel)e.getSource();
    Component c = SwingUtilities.getDeepestComponentAt(p, e.getX(), e.getY());
    if(c!=null && c instanceof JLabel) {
      p.draggingLabel = (JLabel)c;
      p.getTransferHandler().exportAsDrag(p, e, TransferHandler.MOVE);
    }
  }
}





/**
 * LabelTransferHandler extends TransferHandler and is used to give JLabels the ability to switch between DragPanels.
 * @author Patrick,Dom,Chris,Rafael
 *
 */

class LabelTransferHandler extends TransferHandler {
  private DragPanel _src;
  private DragGUI _g;
  private boolean _isMovable;  // represents moving students that already exist
  private final DataFlavor localObjectFlavor;
  private final JLabel label = new JLabel() {
    @Override public boolean contains(int x, int y) {
      return false;
    }
  };
  /**
   * loadImage(String fileName)
   * 
   * Prepares and returns a BufferedImage based on its file name.
   * @param fileName (file name)
   * @return buff (the buffered image)
   **/
  public BufferedImage loadImage(String fileName){
	  BufferedImage buff = null;
	  try{
		  buff = ImageIO.read(getClass().getResourceAsStream(fileName));
	  }
	  catch(IOException e){
		  e.printStackTrace();
		  return null;
	  }
	  return buff;
  }
  private final JWindow window = new JWindow();
  /**
   * getIsMovable()
   * 
   * Accessor method for the variable _isMovable.
   * @return _isMovable (if the JLabel is movable)
   */
  public boolean getIsMovable(){
	  return _isMovable;
  }
  
 
  public LabelTransferHandler(DragGUI g, boolean b) {
	 _isMovable = b;
	_g = g;
    //System.out.println("LabelTransferHandler");
    localObjectFlavor = new ActivationDataFlavor(
      DragPanel.class, DataFlavor.javaJVMLocalObjectMimeType, "JLabel");
    window.add(label);
    window.setAlwaysOnTop(true);
    //window.setBackground(new Color(0,true));
    DragSource.getDefaultDragSource().addDragSourceMotionListener(
    new DragSourceMotionListener() {
      @Override public void dragMouseMoved(DragSourceDragEvent dsde) {
        Point pt = dsde.getLocation();
        pt.translate(5, 5); // offset
        window.setLocation(pt);
      }
    });
  }
  
  
  /**
   * createTranferable(JComponent c)
   * 
   * Creates an icon that will be visibly dragged when moving a JLabel.
   */
  
  @Override protected Transferable createTransferable(JComponent c) {
    //System.out.println("createTransferable");
    DragPanel p = (DragPanel)c;
    _src = p;
    JLabel l = p.draggingLabel;
    String text = l.getText();
   
    final DataHandler dh = new DataHandler(c, localObjectFlavor.getMimeType());
    if(text==null) return dh;
    final StringSelection ss = new StringSelection(text+"\n");
    return new Transferable() {
      @Override public DataFlavor[] getTransferDataFlavors() {
        ArrayList<DataFlavor> list = new ArrayList<DataFlavor>();
        for(DataFlavor f:ss.getTransferDataFlavors()) {
          list.add(f);
        }
        for(DataFlavor f: dh.getTransferDataFlavors()) {
          list.add(f);
        }
        return list.toArray(dh.getTransferDataFlavors());
      }
      public boolean isDataFlavorSupported(DataFlavor flavor) {
        for (DataFlavor f: getTransferDataFlavors()) {
          if (flavor.equals(f)) {
            return true;
          }
        }
        return false;
      }
      public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if(flavor.equals(localObjectFlavor)) {
          return dh.getTransferData(flavor);
        } else {
          return ss.getTransferData(flavor);
        }
      }
    };
  }
  
  
  
  
  
  /**
   * canImport(TransferSupport support
   * 
   * Returns whether you can import the JLabel into the DragPanel
   * @return true (if you can)
   */
  @Override public boolean canImport(TransferSupport support) {
    if(!support.isDrop()) {
      return false;
    }
    return true;
  }
  
  
  
  /**
   * getSourceActions(JComponent c)
   * 
   * Stores the information about the dragged image and also changes the picture, the returns the location.
   * return MOVE (the location)
   */
  
  @Override public int getSourceActions(JComponent c) {
    //System.out.println("getSourceActions");
    DragPanel p = (DragPanel)c;
    label.setIcon(new ImageIcon(loadImage("/images/player.png")));
    label.setText(p.draggingLabel.getText());
    window.pack();
    Point pt = p.draggingLabel.getLocation();
    SwingUtilities.convertPointToScreen(pt, p);
    window.setLocation(pt);
    window.setVisible(true);
    return MOVE;
  }
  
  
  
  /**
   * importData(TransferSupport support)
   * 
   * Handles what happens when you drag certain icons over certain DragPanels i.e. when you're adding new students.
   * @return true(if the data was imported)
   */
  
  
  @Override public boolean importData(TransferSupport support) {
    //System.out.println("importData");
    if(!canImport(support)) return false;
    DragPanel target = (DragPanel)support.getComponent();
    try {
      DragPanel src = (DragPanel)support.getTransferable().getTransferData(localObjectFlavor);
      JLabel l = new JLabel();
      l.setIcon(src.draggingLabel.getIcon());
      l.setText(src.draggingLabel.getText());
      
      
      if(_g.getGameDriver().getCurrentPlayer().getOnhand() > 0 && l.getText().equals("") && !target.getDept().getName().equals("drag") && _g.getGameDriver().getCurrentPlayer().getName().equals(target.getDept().getChair().getName())){  // handles adding new students to selected departments
    	  	_g.getGameDriver().getCurrentPlayer().removeOnHand(1);
    	 	_g.getDeptFromPanel(target).addNewStudent(_g.getGameDriver().getCurrentPlayer(), target.getDept());
    	 	_g.updateUI();
       }
      else if( l.getText().equals("") && !_g.getGameDriver().getCurrentPlayer().getName().equals(target.getDept().getChair().getName())&&_g.getGameDriver().getCurrentPlayer().getOnhand() > 0){JOptionPane.showMessageDialog(new Frame(),"You are not chair in this department.");}
      else if( l.getText().equals("") && l.getText().equals("") && !target.getDept().getName().equals("drag") && _g.getGameDriver().getCurrentPlayer().getName().equals(target.getDept().getChair().getName())){JOptionPane.showMessageDialog(new Frame(),"You have no more students to add.");}

      boolean isChair = src.getDept().getChair().equals(_g.getGameDriver().getCurrentPlayer());
      boolean canMove = isChair && src.getDept().getMovableStudents(_g.getGameDriver().getCurrentPlayer())>1;
      if(canMove && l.getIcon() == null){

    	  if(_g.getDeptFromPanel(target).isAdjacent(_g.getDeptFromPanel(src))){
    		  _g.getDeptFromPanel(target).addStudent(_g.getDeptFromPanel(src).removeStudent(_g.getGameDriver().getCurrentPlayer()));
    		  _g.updateUI();
    		  } // removes a student from src and adds it to target
    	  else{
    		  System.out.println("These departments are not adjacent.");
    		  JOptionPane.showMessageDialog(new Frame(),"These Departments are not adjacent.");

    	  } 
      }else if(src.getDept().getMovableStudents(_g.getGameDriver().getCurrentPlayer())>0 && l.getIcon() == null && !isChair){
    	  if(_g.getDeptFromPanel(target).isAdjacent(_g.getDeptFromPanel(src))){
    		  _g.getDeptFromPanel(target).addStudent(_g.getDeptFromPanel(src).removeStudent(_g.getGameDriver().getCurrentPlayer()));
    		  _g.updateUI();
    		  } // removes a student from src and adds it to target
    	  else{
    		  System.out.println("These departments are not adjacent.");
    		  JOptionPane.showMessageDialog(new Frame(),"These Departments are not adjacent.");

    	  } 
      }
       else{ if(l.getIcon() == null && getIsMovable() && _g.getGameDriver().getCurrentPlayer().getOnhand() < 1){JOptionPane.showMessageDialog(new Frame(),"There are no more remaining movable students.");}
       }
    	  
      


      //target.add(l); //adds the label to the dragpanel
      target.revalidate();
      return true;
    } catch(UnsupportedFlavorException ufe) {
      ufe.printStackTrace();
    } catch(java.io.IOException ioe) {
      ioe.printStackTrace();
    }
    return false;
  }
  /**
   * exportDone(JComponent c, Transferable data, int action)
   * 
   * Resets and repaints everything.
   */
  @Override protected void exportDone(JComponent c, Transferable data, int action) {
    // actions for adding student to new dept.
    DragPanel src = (DragPanel)c;
    if(action == TransferHandler.MOVE) {
     // src.remove(src.draggingLabel); // gets rid of original label
      src.revalidate();
      src.repaint();
    }
    src.draggingLabel = null;
    window.setVisible(false);
  }
  
  
}