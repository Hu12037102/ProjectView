# ProjectView是针对项目中常用到的TitleView和ItemView
## 抽成自定义样式，方便大家自己定义，拓展功能强
### 效果预览
![动画效果](./ProjectView.gif)
### 使用方法
```xml
<declare-styleable name="ItemView">
        <!--Item左标题Left图标-->
        <attr name="title_left_icon" format="reference" />
        <!--Item左标题Top图标-->
        <attr name="title_top_icon" format="reference" />
        <!--Item左标题Right图标-->
        <attr name="title_right_icon" format="reference" />
        <!--Item左标题Bottom图标-->
        <attr name="title_bottom_icon" format="reference" />
        <!--Item左标题标题-->
        <attr name="title_data" format="reference|string" />
        <!--Item左标题大小-->
        <attr name="title_text_size" format="dimension" />
        <!--Item左标题颜色-->
        <attr name="title_text_color" format="reference|color" />
        <!--Item左标题与图标内边距-->
        <attr name="title_drawable_padding" format="dimension" />
        <!--Item要不要显示上线-->
        <attr name="show_top_line" format="boolean" />
        <!--Item上线颜色-->
        <attr name="top_line_color" format="color|reference" />
        <!--Item右标题Left图标-->
        <attr name="content_left_icon" format="reference" />
        <!--Item右标题Top图标-->
        <attr name="content_top_icon" format="reference" />
        <!--Item右标题Right图标-->
        <attr name="content_right_icon" format="reference" />
        <!--Item右标题Bottom图标-->
        <attr name="content_bottom_icon" format="reference" />
        <!--Item右标题标题-->
        <attr name="content_data" format="string|reference" />
        <!--Item右标题标题大小-->
        <attr name="content_text_size" format="dimension" />
        <!--Item右标题标题颜色-->
        <attr name="content_text_color" format="reference|color" />
        <!--Item右标题与图标内边距-->
        <attr name="content_drawable_padding" format="dimension" />
        <!--Item右标题下线-->
        <attr name="show_bottom_line" format="boolean" />
        <!--Item右标题标下线颜色-->
        <attr name="bottom_line_color" format="color|reference" />
        <!--Item选择器样式-->
        <attr name="selector_drawable" format="reference" />
    </declare-styleable>
   ```