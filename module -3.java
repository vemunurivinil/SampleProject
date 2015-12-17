//Registation.java
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Registration extends Activity implements OnClickListener, OnItemSelectedListener

{

 private Button mSubmit;
 private Button mCancel;
 private EditText mUsername;
 private EditText mPassword;
 private EditText mEmail;
 
 protected void onCreate(Bundle savedInstanceState) 
 {
  
  
  super.onCreate(savedInstanceState);
  setContentView(R.layout.register);
  
  mSubmit = (Button)findViewById(R.id.submit);
  mSubmit.setOnClickListener(this);
  
  mCancel = (Button)findViewById(R.id.cancel);
  mCancel.setOnClickListener(this);
 
  mUsername = (EditText)findViewById(R.id.reuname);
  mPassword = (EditText)findViewById(R.id.repass);
  mEmail = (EditText)findViewById(R.id.eemail);
  mPhone = (EditText)findViewById(R.id.ephone);
   
 }
 
 public void onClick(View v) 
 {
  
  switch(v.getId())
	{
  
  	case R.id.cancel:
   	Intent i = new Intent(getBaseContext(), Registration.class);
   	startActivity(i);
 	break;
   
  	case R.id.submit:
   	String uname = mUsername.getText().toString();
   	String pass = mPassword.getText().toString();
  	String email = mEmail.getText().toString();
   	String phone=mPhone.getText().toString();
   	Intent i_register = new Intent(Registration.this, LoginActivity.class);
    	startActivity(i_register);
	break;
	}
      
 }
}


//LoginActivity.java


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener 
{
 
 Button mLogin;
 Button mRegister;
 
 EditText muname;
 EditText mpassword;
  
	public void onCreate(Bundle savedInstanceState) 
   	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        mRegister = (Button)findViewById(R.id.register);
        mRegister.setOnClickListener(this);
        
        mLogin = (Button)findViewById(R.id.login);
        mLogin.setOnClickListener(this); 
        
   	}

	 public void onClick(View v) 
	 {
		 switch(v.getId())
 		 {
 
 		 case R.id.register:
       		 Intent i = new Intent(getBaseContext(), Registration.class);
  		 startActivity(i);
  		 break;
  	
        	 case R.id.login:
  
		  muname = (EditText)findViewById(R.id.Ledituname);
		  mpassword = (EditText)findViewById(R.id.Leditpw);
	  
		  String username = muname.getText().toString();
		  String password = mpassword.getText().toString();
	  
		  Intent in = new Intent(getBaseContext(), WebPage.class);
		  in.putExtra("UserName", muname.getText().toString());
		  startActivity(in);
	   	  }
  	}
 
 }

//WebPage.java

import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WebPage extends ListActivity
{
 	protected TextView gritting;
 
	public void onCreate(Bundle savedInstanceState) 
        {
         	super.onCreate(savedInstanceState);
         	setContentView(R.layout.webPage);
         
      		gritting = (TextView) findViewById(R.id.txt_loggedName);
        	Intent intent = getIntent();
       	 	String name  = intent.getStringExtra("UserName");
        	gritting.setText("Welcome"+name);
   
   
   	} 
}




