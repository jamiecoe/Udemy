terraform {
  backend "s3" {
    bucket = "jamie-coe-terraform-state"
    key = "terraform/demo4"
  }
}
