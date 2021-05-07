package com.lipskii.ski_jumping_system.bucket;

public enum BucketName {

    PROFILE_IMAGE();

    private final String bucketName;

    BucketName() {
        this.bucketName = "skijumpingstats";
    }

    public String getBucketName() {
        return bucketName;
    }
}
