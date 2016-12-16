package eu.chs_pk_cavies.psimkovic.datumyporodu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebView;

import static eu.chs_pk_cavies.psimkovic.datumyporodu.R.id.action_about;
import static eu.chs_pk_cavies.psimkovic.datumyporodu.R.id.webView;

public class AboutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle(getString(R.string.action_about));
        WebView webView1 = (WebView)findViewById(R.id.webView);
        webView1.loadData("<center><h1>Šimkovič Peter</h1><h3>CHS PK Cavies<br/><a href=\"mailto:info@chs-pk-cavies.eu\">info@chs-pk-cavies.eu</a></h3></center><h4 style=\"text-align:justify\">Ide o veľmi jednoduchú aplikáciu na orientačný výpočet dátumu pôrodu u morčiat. Stačí zadať dátum nakrytia, alebo oddelenia a následne aplikácia zobrazí tri dátumy. 1. najskorší termín, 2. optimálny a 3. najneskorší termín pôrodu. Samozrejme, ide čisto o štatistické výpočty a realita sa môže líšiť od vypočítaných dátumov. Verím, že vám táto aplikácia zjednoduší život a uľahčí často vykonávané operácie ako je výpočet dátumu pôrodu.</h4>", "text/html; charset=UTF-8", null);
    }
}
