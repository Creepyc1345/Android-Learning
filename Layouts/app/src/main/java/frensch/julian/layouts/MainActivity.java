package frensch.julian.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

/* Activity Main Relative Layout:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/firstRelLayout"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="100dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Name"
            android:id="@+id/txtName"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Last Name"
            android:id="@+id/txtLastName"
            android:layout_toRightOf="@id/txtName"
            android:layout_marginLeft="10dp"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Email"
            android:id="@+id/txtEmail"
            android:layout_toRightOf="@id/txtLastName"
            android:layout_marginLeft="10dp"/>

    </RelativeLayout>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World"
        android:layout_below="@id/firstRelLayout"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="10dp"
        android:id="@+id/txtHello"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Say Hello"
        android:id="@+id/btnHello"
        android:layout_below="@id/txtHello"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="15dp"/>


</RelativeLayout>

 */
/*Activity Main Linear Layout
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World"
        android:id="@+id/txtHello"
        android:background="#00FFFF"
        android:layout_weight="20"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Name"
        android:id="@+id/txtName"
        android:layout_marginTop="15dp"
        android:background="#FF00FF"
        android:layout_weight="80"/>

</LinearLayout>

 */