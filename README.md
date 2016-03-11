# ReUsableActivity

## 简介

一个可以重复利用的Activity.通过设置不同的Fragment加入到一个可复用的Activity中实现代码的精简。

这个仓库可以用来精简项目中拥有大量重复的AppBar布局的Android App。

## 介绍

一直以来，大家对臃肿的Activity就不是很喜欢，都在试图减少Activity的数量，通过利用Fragment来实现代码的精简和提高运行效率。这个仓库就是设计了一个可以重复利用的Actvity，用填充Fragment的方式来进行代码精简。大大减少了Activity的数量。

同时，我承认这个只是一种重复利用的思想，至于更优雅的实现方式还请各位指教。

最后效果如下：

![](https://github.com/fuxuemingzhu/fuxuemingzhu.github.io/blob/master/images/ReUsableActivity-Using/fragments.gif?raw=true)

以下代码来获取通用Activity向外界展示的式样。fragmentType声明了加载哪一种Fragment,title声明了Activity应该显示的title.

        // 获取启动该Result的Intent
        Intent intent = getIntent();
        // 获取该intent所携带的数据
        Bundle data = intent.getExtras();
        // 从Bundle包中取出数据
        fragmentType = data.getInt("fragmentType");
        title = data.getString("title");

以下代码来说明要加载的Fragment.是由传入的fragmentType来确定的。

        switch (fragmentType) {
            case 0:
                title = "空白界面";
                fragment = new BaseFragment();
                break;
            default:
                /////////////////////////////////////////////////////////
                fragment = new TestFragment();

				// 把参数传给fragment。
                fragment.setArguments(data);
                break;
        }

其他的交给ReUsableActivity来实现。即是由FragmentManager来管理。和普通的Activity中显示Fragment原理相同，因此不做详细介绍，可参见代码。

上面Demo的代码是在Fragment中点击向ReUsableActivity传参数用来显示title，同时新的ReUsableActvity向新的Fragment传数据用来Fragment的展示。

在实际利用中，在需要用ReUsableActivity时传递给ReUsableActivity参数并且打开此Activity即可。

上面的项目的结构如下，虽然有众多的Acitvity显示，但是代码中却只有两个Acitvity.

![](https://github.com/fuxuemingzhu/fuxuemingzhu.github.io/blob/master/images/ReUsableActivity-Using/project.JPG?raw=true)

## 结语

尽可能进行代码复用，来精简项目，这个是项目中的一个小小的经验，分享出来，希望大家能提供一个更好的解决方案。

## Lincence

> Copyright 2016 fuxuemingzhu

> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.