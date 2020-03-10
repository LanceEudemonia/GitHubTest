/**
 * @Author: liyi
 * @Date: 2018/12/13 上午10:38
 */
public enum DogEnum {
    DOUDOU("doudou","cute"),GUOGUO("guoguo","ugly");
    private String name;
    private String miaoshu;

    public String getName() {
        return name;
    }


    public String getMiaoshu() {

        return miaoshu;
    }


    DogEnum(String name, String miaoshu) {
        this.name = name;
        this.miaoshu = miaoshu;
    }
}
