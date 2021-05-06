package com.lipskii.ski_jumping_system.bucket;

public enum BucketName {

    PROFILE_IMAGE("skijumpingstats");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
