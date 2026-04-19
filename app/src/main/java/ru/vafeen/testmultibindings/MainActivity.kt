package ru.vafeen.testmultibindings

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.vafeen.test1.Interface
import javax.inject.Inject
import kotlin.reflect.KClass

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    fun inject(
        set: @JvmSuppressWildcards Set<Interface>,
        map: @JvmSuppressWildcards Map<Class<*>, Interface>
    ) {
        Log.e("set", set.toString())
        Log.e("map", map.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}