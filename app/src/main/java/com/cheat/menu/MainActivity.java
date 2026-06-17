package com.cheat.menu;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.SeekBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private Switch switchEsp, switchGhost;
    private SeekBar seekBarStrength;
    private RadioGroup radioGroupAim;
    private Spinner spinnerGame;
    private Button btnSave;
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("cheat_config", MODE_PRIVATE);
        switchEsp = findViewById(R.id.switch_esp);
        switchGhost = findViewById(R.id.switch_ghost);
        seekBarStrength = findViewById(R.id.seekbar_strength);
        radioGroupAim = findViewById(R.id.radiogroup_aim);
        spinnerGame = findViewById(R.id.spinner_game);
        btnSave = findViewById(R.id.btn_save);
        switchEsp.setChecked(prefs.getBoolean("esp_enabled", false));
        switchGhost.setChecked(prefs.getBoolean("ghost_enabled", false));
        seekBarStrength.setProgress(prefs.getInt("strength", 30));
        radioGroupAim.check(prefs.getInt("aim_mode", R.id.radio_body));
        String[] games = {"Free Fire", "PUBG Mobile", "Call of Duty"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, games);
        spinnerGame.setAdapter(adapter);
        spinnerGame.setSelection(prefs.getInt("selected_game", 0));
        btnSave.setOnClickListener(v -> saveConfig());
    }
    private void saveConfig() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("esp_enabled", switchEsp.isChecked());
        editor.putBoolean("ghost_enabled", switchGhost.isChecked());
        editor.putInt("strength", seekBarStrength.getProgress());
        editor.putInt("aim_mode", radioGroupAim.getCheckedRadioButtonId());
        editor.putInt("selected_game", spinnerGame.getSelectedItemPosition());
        editor.apply();
    }
}
