package com.example.twitterwithfragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class FragmentPosts extends Fragment implements IChange {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private boolean isAllPostVersion;
    private List<Post> dataSet = new ArrayList<>();
    private PostsContainer postsContainer = PostsContainer.get();

    public static FragmentPosts newInstance(boolean isAllPostVersion) {

        FragmentPosts fragment = new FragmentPosts();
        fragment.isAllPostVersion = isAllPostVersion;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_posts,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);

        if(isAllPostVersion){
            dataSet.addAll(postsContainer.getAllPosts());
        }
        else{
            dataSet.addAll(postsContainer.getLikedPosts());
        }
        adapter = new PostAdapter(dataSet,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;

    }
    public void onPostLike()
    {
        ((MainActivity)getActivity()).onPostLike();
    }
    public void updateLike(){
        dataSet.clear();
        dataSet.addAll(postsContainer.getLikedPosts());
        adapter.notifyDataSetChanged();
    }
    public void updatePage(){
        dataSet.clear();
        dataSet.addAll(postsContainer.getAllPosts());
        adapter.notifyDataSetChanged();
    }

}
