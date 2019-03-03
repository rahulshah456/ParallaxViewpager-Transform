# ParallaxViewpager-Transform
An easy-to-use ViewPager implementation with Parallax effect.
Basic View pager is used with PagerTransform to get parallax effect , no extra libray is used or any subclasses.

# Example Code
```java
viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                if (position <= -1 || position >= 1){
                    page.findViewById(R.id.imageViewID).setVisibility(View.VISIBLE);
                }
                else if( position == 0) {
                    page.findViewById(R.id.imageViewID).setVisibility(View.VISIBLE);
                } else {
                    page.findViewById(R.id.imageViewID).setTranslationX(-position * page.getWidth() / 2);
                    //Use this to add white shadow while sliding
                    //page.setAlpha(1.0f - Math.abs(position));
                }
            }
        });
```

# Demo
![alt text](https://github.com/rahulshah456/ParallaxViewpager-Transform/blob/master/slideshow.gif)
