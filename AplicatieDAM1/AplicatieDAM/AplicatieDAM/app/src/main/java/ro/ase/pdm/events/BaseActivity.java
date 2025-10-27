package ro.ase.pdm.events;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class BaseActivity extends AppCompatActivity {

    /*
    BaseActivity will hold all common traits of pages.
    Ex: All pages should have the toolbar.
     */
    protected void setupToolbar(MaterialToolbar toolbar, @Nullable String title, boolean showBackButton) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title != null ? title : "");
                getSupportActionBar().setDisplayHomeAsUpEnabled(showBackButton);
            }
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
    }
}
