package com.example.gojektemp.views
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import com.example.gojektemp.R
import com.example.gojektemp.models.StarWarsVM
import com.example.gojektemp.pagination.StarWarsPagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mrecyclerview : RecyclerView
    lateinit var madapter : StarWarsPagingAdapter
    lateinit var mviewmodel : StarWarsVM
    lateinit var msearch : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mrecyclerview = findViewById(R.id.starwars_list)
        msearch = findViewById(R.id.search_items)
        madapter = StarWarsPagingAdapter()
        mviewmodel = ViewModelProvider(this)[StarWarsVM::class.java]

        mrecyclerview.layoutManager = LinearLayoutManager(this)
        mrecyclerview.adapter = madapter

        mviewmodel.list.observe(this){
            madapter.submitData(lifecycle,it)
        }

        msearch.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                madapter.setSearchQuery(newText.orEmpty())
                return true
            }
        })

    }
}
