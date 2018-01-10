package jumpassist.qa.jumpapp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_start_wechart = (TextView) findViewById(R.id.tv_start_wechart);
        tv_start_wechart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWeChart();
            }
        });
    }

    private void startWeChart(){
        if (!isWeixinAvilible(this)){
            Toast.makeText(this, "请检查是否安装了微信", Toast.LENGTH_SHORT).show();
            return;
        }
//        Intent intent = new Intent();
//        ComponentName cmp = new ComponentName("com.tencent.mm","com.tencent.mm.ui.LauncherUI");
//        intent.setAction(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_LAUNCHER);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.setComponent(cmp);
//        String cname = cmp.getClassName();
//
//        startActivity(intent);
//
//
//        CalculateService.startJumpSevice(this);
    }

    private boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }
}
