package com.example.twitterwithfragments;

import android.os.Parcel;
import android.os.Parcelable;


public class Post implements Parcelable {
    private String login;
    private String date;
    private String post;
    private int likeCnt;
    private int profileImg;
    private String name;
    private String commentCnt;
    private String tweetCnt;
    private boolean isLiked;
    private int redlike;

    Post(String name, String login, String date, String post, int profileImg, String commentCnt, String tweetCnt, int likeCnt, boolean isLiked, int redlike) {
        this.name = name;
        this.login = login;
        this.date = date;
        this.post = post;
        this.profileImg  = profileImg;
        this.commentCnt = commentCnt;
        this.tweetCnt = tweetCnt;
        this.likeCnt = likeCnt;
        this.isLiked = isLiked;
        this.redlike = redlike;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

    public String getLogin() {
        return login;
    }

    public String getDate() {
        return date;
    }

    public String getPost() {
        return post;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public String getName() {
        return name;
    }

    public String getCommentCnt() {
        return commentCnt;
    }

    public String getTweetCnt() {
        return tweetCnt;
    }

    public int getRedlike() {
        return redlike;
    }

    public void setRedlike(int redlike) {
        this.redlike = redlike;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeString(this.date);
        dest.writeString(this.post);
        dest.writeInt(this.likeCnt);
        dest.writeInt(this.profileImg);
        dest.writeString(this.name);
        dest.writeString(this.commentCnt);
        dest.writeString(this.tweetCnt);
        dest.writeInt(this.redlike);

    }

    private Post(Parcel in){
        this.login=in.readString();
        this.date=in.readString();
        this.post=in.readString();
        this.name=in.readString();
        this.commentCnt=in.readString();
        this.tweetCnt=in.readString();
        this.likeCnt=in.readInt();
        this.profileImg=in.readInt();
        this.redlike=in.readInt();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel parcel) { return new Post(parcel); }

        public Post[] newArray(int i) {
            return new Post[i];
        }
    };
}
