# ReUsableActivity

# 简介

一个可以重复利用的Activity.通过设置不同的Fragment加入到一个可复用的Activity中实现代码的精简。

# 介绍

一直以来，大家对臃肿的Activity就不是很喜欢，都在试图减少Activity的数量，通过利用Fragment来实现代码的精简和提高运行效率。这个仓库就是设计了一个可以重复利用的Actvity，用填充Fragment的方式来进行代码精简。大大减少了Activity的数量。

同时，我承认这个只是一种重复利用的思想，至于更优雅的实现方式还请各位指教。

以下代码来获取通用Activity向外界展示的式样。fragmentType声明了加载哪一种Fragment,title声明了Activity应该显示的title.

        // 获取启动该Result的Intent
        Intent intent = getIntent();
        // 获取该intent所携带的数据
        Bundle data = intent.getExtras();
        // 从Bundle包中取出数据
        fragmentType = data.getInt("fragmentType");
        title = data.getString("title");

以下代码来说明要加载的Fragment.

        switch (fragmentType) {
            case 0:
                title = "空白界面";
                fragment = new BaseFragment();
                break;
            default:
                /////////////////////////////////////////////////////////
                fragment = new TestFragment();

                fragment.setArguments(data);
                break;
        }

其他的交给ReUsableActivity来实现。即是由FragmentManager来管理。