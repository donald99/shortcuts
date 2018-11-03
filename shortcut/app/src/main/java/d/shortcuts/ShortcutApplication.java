package d.shortcuts;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class ShortcutApplication extends Application {

    private ShortcutManager mShortcutManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate() {
        super.onCreate();
        setupShortcuts();
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setupShortcuts() {
        mShortcutManager = getSystemService(ShortcutManager.class);
        List<ShortcutInfo> infos = new ArrayList<>();
        for (int i = 0; i < mShortcutManager.getMaxShortcutCountPerActivity(); i++) {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.setAction(Intent.ACTION_VIEW);
            intent.putExtra("info", "this is info!");
            ShortcutInfo info = new ShortcutInfo.Builder(this, "ID:" + i)
                    .setShortLabel("short label")
                    .setLongLabel("long label")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                    .setIntent(intent)
                    .build();
            infos.add(info);
        }
        mShortcutManager.setDynamicShortcuts(infos);
    }
}
