package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateEmployee extends JFrame implements ActionListener {
    JTextField teducation, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation, tname;
    JLabel tempid;
    JButton update, back;
    String number;

    updateEmployee(String number) {
        this.number = number;

        getContentPane().setBackground(new Color(163, 255, 188));
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        // Father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        // Date of Birth
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        // Salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        // Highest Education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);

        // Aadhar
        // Aadhar
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); // Consistent with other labels
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);


        // Employee ID
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        try{
            conn c = new conn();
            String query="select * from employee where empID='"+number+"'";
            ResultSet resultSet=c.statement.executeQuery(query);
            while(resultSet.next())
            {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob")); // Correct column name
                taddress.setText(resultSet.getString("Address"));
                tsalary.setText(resultSet.getString("Salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("Email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empid"));
                tdesignation.setText(resultSet.getString("designation"));

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // Add Button
        update = new JButton("UPDATE");
        update.setBounds(450, 550, 150, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Frame Settings
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Add functionality here
        if(e.getSource()==update)
        {
            String fname=tfname.getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=teducation.getText();
            String designation=tdesignation.getText();


            try{
                conn c = new conn();
                String query = "update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid ='"+number+"'";
                c.statement.executeUpdate(query);  // Use executeUpdate for update queries

                JOptionPane.showMessageDialog(null,"details updated successfully");

            }
            catch(Exception E)
            {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new updateEmployee("");  // Passing Employee ID as argument
    }
}
