# JetPackDemo（学习）
##开发环境##

- AndroidStudio 3.5.3
- JDK 1.8
- 语言：JAVA

一：创建工程==>Fragment + ViewModel

二：在res下面创建navigation文件夹

    <navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/login_navigation"
    app:startDestination="@id/loginFragment">

    <fragment
        android:id="@+id/mainFragment"
        	android:name="com.wmj.jetpackdemo.ui.main.MainFragment	"
        android:label="main_fragment"
        tools:layout="@layout/main_fragment" />
    <fragment
        android:id="@+id/loginFragment"
        	android:name="com.wmj.jetpackdemo.ui.login.LoginFragme	nt"
        android:label="activity_login"
        tools:layout="@layout/activity_login" />
	</navigation>


> "mainFragment" "loginFragment"分别是两个viewModel对应的fragment

> activity作为承载fragment的主页面，fragment实现具体逻辑

三：动态更新bean数据（LiveData）

	 public class LoginData extends LiveData<LoginData> {
	    private String name;
	    private String pwd;
	
	    public void setName(String name) {
	        this.name = name;
	        postValue(this);
	    }
	
	    public String getName() {
	        return name;
	    }
	
	    public String getPwd() {
	        return pwd;
	    }
	
	    public void setPwd(String pwd) {
	        this.pwd = pwd;
	        postValue(this);
	    }
	}
>通过继承LiveData
>
>并在set方法增加postValue(this)

四：创建业务ViewModel继承ViewModel
实现获取数据方法：

    public class LoginViewModel  extends ViewModel {
	   private LoginData data = new LoginData();
	   public LoginData  getLoginData(){
	       return data;
	   }
	}
五：监听数据改变并更新View

       final LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        LoginData loginData = loginViewModel.getLoginData();
        loginData.observe(getActivity(), new Observer<LoginData>() {
            @Override
            public void onChanged(LoginData loginData) {
                name.setText(loginData.getName());
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.getLoginData().setName("789");
	//                Navigation.findNavController(v).navigate(R.id.mainFragment);
	            }
	        });
六：相关方法：

> Navigation的页面跳转
> > Navigation.findNavController(v).navigate(R.id.mainFragment)
> 