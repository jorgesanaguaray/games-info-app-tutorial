package com.jorgesanaguaray.gamesinfoapptutorial

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import coil.load
import com.jorgesanaguaray.gamesinfoapptutorial.databinding.ActivityMainBinding
import com.jorgesanaguaray.gamesinfoapptutorial.ui.GameAdapter
import com.jorgesanaguaray.gamesinfoapptutorial.ui.MainViewModel
import com.jorgesanaguaray.gamesinfoapptutorial.ui.detail.DetailActivity
import com.jorgesanaguaray.gamesinfoapptutorial.util.Constants.Companion.KEY_GAME_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var gameAdapterA: GameAdapter
    private lateinit var gameAdapterB: GameAdapter
    private lateinit var gameAdapterC: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get()
        gameAdapterA = GameAdapter()
        gameAdapterB = GameAdapter()
        gameAdapterC = GameAdapter()

        mainViewModel.game.observe(this) {

            binding.apply {

                mTitle.text = it.title
                mImage.load(it.thumbnail) {
                    placeholder(R.drawable.ic_image)
                    error(R.drawable.ic_image)
                    crossfade(true)
                    crossfade(400)
                }
                mShortDescription.text = it.short_description
                mButtonGoToTheGamePage.setOnClickListener { _ -> setOnButtonClick(it.game_url) }
                mCardViewGame.setOnClickListener { _ -> setOnCardViewClick(it.id) }

            }

        }

        mainViewModel.gamesA.observe(this) {

            gameAdapterA.setGames(it)
            binding.mRecyclerViewA.adapter = gameAdapterA
            gameAdapterA.setOnButtonClick(object : GameAdapter.OnButtonClick {
                override fun onClick(gameUrl: String) {
                    setOnButtonClick(gameUrl)
                }
            })
            gameAdapterA.setOnCardViewClick(object : GameAdapter.OnCardViewClick {
                override fun onClick(id: Int) {
                    setOnCardViewClick(id)
                }
            })

        }

        mainViewModel.gamesB.observe(this) {

            gameAdapterB.setGames(it)
            binding.mRecyclerViewB.adapter = gameAdapterB
            gameAdapterB.setOnButtonClick(object : GameAdapter.OnButtonClick {
                override fun onClick(gameUrl: String) {
                    setOnButtonClick(gameUrl)
                }
            })
            gameAdapterB.setOnCardViewClick(object : GameAdapter.OnCardViewClick {
                override fun onClick(id: Int) {
                    setOnCardViewClick(id)
                }
            })

        }

        mainViewModel.gamesC.observe(this) {

            gameAdapterC.setGames(it)
            binding.mRecyclerViewC.adapter = gameAdapterC
            gameAdapterC.setOnButtonClick(object : GameAdapter.OnButtonClick {
                override fun onClick(gameUrl: String) {
                    setOnButtonClick(gameUrl)
                }
            })
            gameAdapterC.setOnCardViewClick(object : GameAdapter.OnCardViewClick {
                override fun onClick(id: Int) {
                    setOnCardViewClick(id)
                }
            })

        }

        mainViewModel.nestedScrollViewVisibility.observe(this) {
            binding.mNestedScrollView.visibility = if (it) View.VISIBLE else View.GONE
        }

        mainViewModel.textViewNoInternetVisibility.observe(this) {
            binding.mTextViewNoInternet.visibility = if (it) View.VISIBLE else View.GONE
        }

        mainViewModel.progressBarVisibility.observe(this) {
            binding.mProgressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        binding.mSwipeRefreshLayout.setOnRefreshListener {
            mainViewModel.getGame()
            mainViewModel.getFiveGames()
            binding.mSwipeRefreshLayout.isRefreshing = false
        }

    }

    private fun setOnButtonClick(gameUrl: String) {
        val uri = Uri.parse(gameUrl)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun setOnCardViewClick(id: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(KEY_GAME_ID, id)
        startActivity(intent)
    }

}