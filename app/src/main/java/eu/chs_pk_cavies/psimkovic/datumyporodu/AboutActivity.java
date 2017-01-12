package eu.chs_pk_cavies.psimkovic.datumyporodu;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

public class AboutActivity extends Activity {

    public String versionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle(getString(R.string.action_about));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        try {
            versionName = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        String s="Debug-infos:";
        s += "<br/> App Version: " + versionName;
        s += "<br/> OS Version: " + System.getProperty("os.version") + " (" + android.os.Build.VERSION.INCREMENTAL + ")";
        s += "<br/> OS API Level: "+android.os.Build.VERSION.RELEASE + " ("+android.os.Build.VERSION.SDK_INT+")";
        s += "<br/> Device: " + android.os.Build.DEVICE;
        s += "<br/> Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";

        WebView webView1 = (WebView)findViewById(R.id.webView);
        webView1.loadData(
                "<center><h1>"+getString(R.string.app_name)+"</h1>"+
                "<h2>Šimkovič Peter<br/>CHS PK Cavies<br/><a href=\"mailto:info@chs-pk-cavies.eu\">info@chs-pk-cavies.eu</a></h2></center>"+
                "<h4 style=\"text-align:justify\">Ide o veľmi jednoduchú aplikáciu na orientačný výpočet dátumu pôrodu u morčiat. Stačí zadať dátum nakrytia, alebo oddelenia a následne aplikácia zobrazí tri dátumy. 1. najskorší termín, 2. optimálny a 3. najneskorší termín pôrodu. Samozrejme, ide čisto o štatistické výpočty a realita sa môže líšiť od vypočítaných dátumov. Verím, že vám táto aplikácia zjednoduší život a uľahčí často vykonávané operácie ako je výpočet dátumu pôrodu.</h4><br/>"+
                s, "text/html; charset=UTF-8", null);
    }
}
