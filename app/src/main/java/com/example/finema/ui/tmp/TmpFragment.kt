package com.example.finema.ui.tmp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.finema.R
import com.example.finema.api.DimaVersion.ApiInterface
import com.example.finema.api.DimaVersion.Common
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.finema.R
import com.example.finema.databinding.TmpFragmentBinding
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.sub_model.GenreList
import com.example.finema.ui.base.BaseFragment
import com.example.finema.utlis.APP_ACTIVITY
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Response

class TmpFragment: BaseFragment<TmpViewModel, TmpFragmentBinding>() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mViewModel: TmpViewModel
    lateinit var mService: ApiInterface

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TmpFragmentBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this).get(TmpViewModel::class.java)
        mAuth = FirebaseAuth.getInstance()

          //  Äëÿ ïîëó÷åíèÿ API
        mService = Common.retrofitService
//          ÏÎËÓ×ÈÒÜ ÑÏÈÑÎÊ ÔÈËÜÌÎÂ
        getAllGenresList()
        binding.withGenres.setOnClickListener{
            it.findNavController().navigate(R.id.action_tmpFragment_to_tournamentGenresFragment)

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.genre.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_tmp_to_fragment_genre)
        }
    }

     private fun getAllGenresList() {
        mService.getGenreList().enqueue(object : retrofit2.Callback<GenreList> {
            override fun onResponse(call: Call<GenreList>, response: Response<GenreList>) {
                val responseBody = response.body()!!
                val responseGenreList = responseBody.genres
                for (item in responseGenreList){
                    mViewModel.insert(GenreModel(name = item.name, id = item.id)) {
                        Log.d("WTF","successs")
                    }
                }

                Log.d("WTF", "Nice")
            }

            override fun onFailure(call: Call<GenreList>, t: Throwable) {
                Log.d("WTF1", "Fail" + t.message)
            }
        })


    }

}