from wordcloud import wordcloud
import matplotlib.pyplot as plt  # 图像展示库

with open("三国演义人名词频.txt", encoding='utf-8') as fp:
    wc = wordcloud.WordCloud(
        font_path='../../test6/Test_6_4_InData/simhei.ttf',  # 设置字体格式,设置字体，不指定的话会乱码
        background_color="white",  # 设置背景色
        # mask=mask, # 设置背景图，词云形状
        # max_words=200, # 最多显示词数
        max_font_size=100  # 字体最大值
    )
    wordCounts = {}
    for i in fp:
        j = i.split()  # 按空格区分
        wordCounts[j[0]] = int(j[1])

    wc.generate_from_frequencies(wordCounts)  # 从字典生成词云
    # image_colors = wordcloud.ImageColorGenerator(mask) # 从背景图建立颜色方案
    # wc.recolor(color_func=image_colors) # 将词云颜色设置为背景图方案
    plt.imshow(wc)  # 显示词云
    # plt.axis('off') # 关闭坐标轴
    plt.show()  # 显示图像
    wc.to_file("wordCount_name.jpg")  # 保存到本地
