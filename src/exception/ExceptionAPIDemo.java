package exception;
/*我是一个很惧怕人群和陌生人的人, 因为我总担心会在人群中出丑,惧怕陌生人的指责与嘲讽,虽然渐渐长大以后意识到这是个青春期的遗留问题, 但这个性格或多或少地还在影响着我,虽然不再只会窝在家里不愿社交, 但是一个人走在路上或是下课时人群相反方向的人群里, 还会有股想逃离的感觉
* 但上次被骂了一台,按理来说我应该会羞愧地找个地缝钻进去, 但是没有--一开始很受打击,但慢慢地就很生气,我真真实实地在介绍自己的兴趣爱好,虽然自己文案写的不好也没给老师看,好这个我认,但我好歹是认真准备了,虽然准备时经验不足不够好.
* 你谁啊?说我不要标榜自己,不要讲自己不了解的东西...好像是我的舍友都会更了解我一点吧,我在宿舍的休闲时间大部分都花在与历史新闻相关的影视和书上去了.
* 我只是个爱好者, 我说了我了解"了"好多的历史题材--不是你说的"啊,我很了解历史", 喜欢一个东西有错吗?简单分享一下就要嘲讽我吗? 要是我错了,那好,我价值观世界观有问题,接下来的话就当阴阳怪气.
* 既然要证明我说的话, 好的这次我
* */
public class ExceptionAPIDemo {
    public static void main(String[] args) {
        System.out.println("开始");
        try {
            String str = "abc";
            System.out.println(Integer.parseInt(str));
        }catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("程序结束");
    }
}
