package com.sist.user;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import com.sist.manager.*;
import com.sist.vo.*;
import java.net.*;
public class MovieMain extends JFrame implements ActionListener,MouseListener{
    JTextField tf;
    JButton jb,jb1,prev,next;
    JTable table;
    DefaultTableModel model;
    JLabel la=new JLabel("0 page / 0 pages");
    MovieManager mgr=new MovieManager();
    int curpage=1;
    int totalpage=0;
    public MovieMain()
    {
    	tf=new JTextField();
    	jb=new JButton("검색");
    	jb1=new JButton("목록");
    	prev=new JButton("이전");
    	next=new JButton("다음");
    	String[] col={"순위","","영화명","장르"};
    	Object[][] row=new Object[0][4];
    	
    	model=new DefaultTableModel(row,col)
    	{
    		@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}

    	};
    	
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	table.setRowHeight(30);
    	setLayout(null);
    	tf.setBounds(20, 30, 250, 30);
    	jb.setBounds(280, 30, 150, 30);
    	jb1.setBounds(435,30,150,30);
    	add(tf); add(jb);add(jb1);
    	js.setBounds(20, 70, 700, 450);
    	
    	add(js);
    	JPanel p=new JPanel();
    	p.add(prev);
    	p.add(la);
    	p.add(next);
    	p.setBounds(20, 530, 700, 35);
    	add(p);
    	dataPrint();
    	setSize(760, 640);
    	setVisible(true);
    	prev.addActionListener(this);
    	next.addActionListener(this);
    	jb.addActionListener(this);
    	jb1.addActionListener(this);
    	tf.addActionListener(this);
    	table.addMouseListener(this);
    }
    public void dataPrint()
    {
    	
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	totalpage=mgr.movieTotalPage();
    	la.setText(curpage+" page / "+totalpage+" pages");
    	Movie[] movie=mgr.movieListData(curpage);
    	for(Movie m:movie)
    	{
    		try
    		{
    			URL url=new URL(m.getPoster());
    			Image icon=getImage(new ImageIcon(url), 25, 25);
    			Object[] obj={m.getRank(),new ImageIcon(icon),m.getTitle(),m.getGenre()};
    			model.addRow(obj);
    		}catch(Exception ex) {}
    	}
    }
    public void dataFindPrint(String title)
    {
    	
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	
    	Movie[] movie=mgr.movieFindData(title);
    	for(Movie m:movie)
    	{
    		try
    		{
    			URL url=new URL(m.getPoster());
    			Image icon=getImage(new ImageIcon(url), 25, 25);
    			Object[] obj={m.getRank(),new ImageIcon(icon),m.getTitle(),m.getGenre()};
    			model.addRow(obj);
    		}catch(Exception ex) {}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MovieMain();
	}
	//이미지 처리
	public static Image getImage(ImageIcon icon,int w,int h)
	{
		  return icon.getImage().
				   getScaledInstance(w, h, Image.SCALE_SMOOTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==prev)
		{
			if(curpage>1)
			{
				curpage--;
				dataPrint();
			}
		}
		else if(e.getSource()==next)
		{
			if(curpage<totalpage)
			{
				curpage++;
				dataPrint();
			}
		}
		else if(e.getSource()==jb || e.getSource()==tf)
		{
			String title=tf.getText();
			if(title.length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				tf.requestFocus();
				return;
			}
			dataFindPrint(title);
		}
		else if(e.getSource()==jb1)
		{
			curpage=1;
			dataPrint();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	   if(e.getSource()==table)
	   {
		   if(e.getClickCount()==2)
		   {
			   int row=table.getSelectedRow();
			   String mno=model.getValueAt(row, 0).toString();
			   Movie movie=mgr.movieDetailData(Integer.parseInt(mno));
			   String msg="순위:"+movie.getRank()+"\n"
					     +"영화명:"+movie.getTitle()+"\n"
					     +"감독:"+movie.getDirector()+"\n"
					     +"출연:"+movie.getActor()+"\n"
					     +"장르:"+movie.getGenre()+"\n"
					     +"등급:"+movie.getGrade();
			   JOptionPane.showMessageDialog(this, msg);
					     
		   }
	   }
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
