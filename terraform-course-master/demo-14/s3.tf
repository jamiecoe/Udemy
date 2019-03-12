resource "aws_s3_bucket" "b" {
    bucket = "jamie-mybucket-c29df1"
    acl = "private"

    tags {
        Name = "jamie-mybucket-c29df1"
    }
}
