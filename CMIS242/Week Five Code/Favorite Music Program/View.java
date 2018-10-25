import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class View implements ActionListener{

	private JCheckBox punk1, rock1, country1, rap1;
	private ButtonGroup bg = new ButtonGroup();
	JFrame frame;
	public View(){
		frame = new JFrame("Music I Like");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 180);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(1,3));
		
		JPanel favoritePanel = new JPanel();
		
		JLabel favoriteTitle = new JLabel("Favorite Genre");
		JPanel headerPan = new JPanel();
		headerPan.add(favoriteTitle);
		
		JPanel radioPan = new JPanel();
		radioPan.setLayout(new BoxLayout(radioPan, BoxLayout.Y_AXIS));
		
		JRadioButton punk = new JRadioButton("Punk");
		punk.setActionCommand("Punk.");
		bg.add(punk);
		
		JRadioButton rock = new JRadioButton("Rock");
		rock.setActionCommand("Rock.");
		bg.add(rock);
		
		JRadioButton country = new JRadioButton("Country");
		country.setActionCommand("Country.");
		bg.add(country);
		
		JRadioButton rap = new JRadioButton("Rap");
		rap.setActionCommand("Rap.");
		bg.add(rap);
		
		radioPan.add(favoriteTitle);
		radioPan.add(punk);
		radioPan.add(rock);
		radioPan.add(country);
		radioPan.add(rap);
		radioPan.add(headerPan);
		
		favoritePanel.add(radioPan);
		
		JPanel likeWrapper = new JPanel();
		JPanel likePanel = new JPanel();
		likePanel.setLayout(new BoxLayout(likePanel, BoxLayout.Y_AXIS));
		
		punk1 = new JCheckBox("Punk");
		rock1 = new JCheckBox("Rock");
		country1 = new JCheckBox("Country");
		rap1 = new JCheckBox("Rap");

		JLabel likeGenre = new JLabel("Genres I Like");
		
		likePanel.add(likeGenre);
		likePanel.add(punk1);
		likePanel.add(rock1);
		likePanel.add(country1);
		likePanel.add(rap1);
		likeWrapper.add(likePanel);
		
		JButton runButton = new JButton("Click");
		runButton.addActionListener(this);
		
		frame.add(likeWrapper);
		frame.add(favoritePanel);
		frame.add(runButton);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		String out = "You like ";
		
		ArrayList<String> liked = new ArrayList<String>();
		if(punk1.isSelected()){
			liked.add("Punk");
		}
		if(rock1.isSelected()){
			liked.add("Rock");
		}
		if(country1.isSelected()){
			liked.add("Country");
		}
		if(rap1.isSelected()){
			liked.add("Rap");
		}
		if(liked.size()==0){
			out+="no Genres, ";
		}else{
			for (int i=0;i<liked.size();i++){
				if(i==liked.size()-2){
					out+= liked.get(i) + ", and ";
				}else{
					out += liked.get(i)+", ";
				}
			}
		}
		String finishedOut="";
		try{
			ButtonModel selectedModel = bg.getSelection();
			String currentString = selectedModel.getActionCommand();
			finishedOut = out+="your favorite genre is "+currentString;
		}catch (NullPointerException ex1){
			finishedOut = out+="you do not have a favorite Genre.";
		}
		
		
		JOptionPane.showMessageDialog(null, 
			finishedOut, 
			"Music Tastes", JOptionPane.INFORMATION_MESSAGE);
	}
}