package com.zhijing.shoppingcenter.HomePage.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhijing.shoppingcenter.HomePage.bean.GoodsBean;
import com.zhijing.shoppingcenter.HomePage.bean.ResultBeanData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.app.GoodsInfo;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter implements OnBannerListener {
    private static final int BANNER = 0;
    private static final int CHANNEL = 1;
    private static final int ACT = 2;
    private static final int SECKILL = 3;
    private static final int RECOMMEND = 4;
    private static final int HOT = 5;
    private static final String GOODBEAN = "goodsbean";
    private final LayoutInflater mLayoutInflater;
    private Context context;
    private ResultBeanData.ResultBean resultBean;



    private int currentType = BANNER;

    public HomePageAdapter(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        mLayoutInflater = LayoutInflater.from(context);
    }


    /**
     * 创建ViewHodle
     * @param parent
     * @param viewType 当前de类型
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (viewType == BANNER){
           return new BannerViewHolder(context,mLayoutInflater.inflate(R.layout.banner_viewpage,null));
       }else if (viewType == CHANNEL){
           return new ChannelViewHoder(context,mLayoutInflater.inflate(R.layout.channel_gridview,null));
       }
       else if (viewType == ACT){
           return new ActViewHolder(context,mLayoutInflater.inflate(R.layout.sec_kill_recview,null));
       }
       else if (viewType == SECKILL){
           return new SecKillViewHolder(context,mLayoutInflater.inflate(R.layout.sec_kill_recview,null));
       }else if (viewType == RECOMMEND){
           return new RecomnendViewHolder(context,mLayoutInflater.inflate(R.layout.recomnend_recview,null));
       }

        return null;
    }


    /**
     * 为个个页面绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER){
            BannerViewHolder bannerViewHolder = (BannerViewHolder)holder;
            bannerViewHolder.initData();
            bannerViewHolder.initView();
        }else if (getItemViewType(position) == CHANNEL){
            ChannelViewHoder channelViewHoder = (ChannelViewHoder)holder;
            channelViewHoder.setData(resultBean.getChannel_info());
        }
        else if (getItemViewType(position) == ACT){
            ActViewHolder actViewHolder = (ActViewHolder)holder;
            actViewHolder.setData(resultBean.getDerive_info());
        }
        else if (getItemViewType(position) == SECKILL){
            SecKillViewHolder secKillViewHolder = (SecKillViewHolder)holder;
            secKillViewHolder.setData(resultBean.getDrinks_info());
        }else if (getItemViewType(position) == RECOMMEND){
            RecomnendViewHolder recomnendViewHolder = (RecomnendViewHolder)holder;
            recomnendViewHolder.setData(resultBean.getRecommend_info());
        }
    }

    @Override
    public void OnBannerClick(int position) {
    }

    /**
     * 创建页面BannerViewHolder
     * 初始化banner_viewpage.xml
     * 并在这里进行方法
     */
    class BannerViewHolder extends RecyclerView.ViewHolder implements OnBannerListener {

        private Banner mBanner;
        private MyImageLoader mMyImageLoader;
        private ArrayList<String> list_path;
        private ArrayList<String> list_title;

        private Context context;
        private Banner banner;
        private View view;
        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            banner = itemView.findViewById(R.id.Banner);
        }

        private void initData() {
            list_title = new ArrayList<>();
            list_path = new ArrayList<>();

            for (int i = 0;i<resultBean.getBanner_info().size();i++){
                String urls = resultBean.getBanner_info().get(i).getImage();
                list_path.add(Constants.BASE_IMAGES_URL + urls);
                list_title.add(resultBean.getBanner_info().get(i).getTitle());
            }
        }
        private void initView() {
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            banner.setImageLoader(new MyLoader());
            banner.setBannerAnimation(Transformer.Default);
            banner.setBannerTitles(list_title);
            banner.setDelayTime(3000);
            banner.isAutoPlay(true);
            banner.setIndicatorGravity(BannerConfig.CENTER);
            banner.setImages(list_path)
                    .setOnBannerListener(this)
                    .start();
        }
        @Override
        public void OnBannerClick(int position) {

            Toast.makeText(context,"这是里面图",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 创建页面ChannelViewHoder
     * 初始化channel_gridview
     */
    class ChannelViewHoder extends RecyclerView.ViewHolder {
        private Context context;
        private View view;
        private GridView gridView;
        private ChannelAdapter channelAdapter;
        public ChannelViewHoder(final Context context, View itemview) {
            super(itemview);
            this.context = context;
            gridView = itemview.findViewById(R.id.channel_gridview);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int position, long id) {
                    Toast.makeText(context,"position" + position,Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setData(List<ResultBeanData.ResultBean.ChannelInfoBean> channel_info) {
            channelAdapter = new ChannelAdapter(context,channel_info);
            gridView.setAdapter(channelAdapter);
        }
    }

    /**
     * 创建设备推荐页面
     * 初始化act_viewpager
     * 并在这里进行方法
     */
    class ActViewHolder extends RecyclerView.ViewHolder{

        private Context context;
        private RecyclerView viewPager;
        private ActAdapter actAdapter;
        private TextView view_name;
        private ImageView view_logo;

        public ActViewHolder(Context context,View itemView) {
            super(itemView);
            this.context = context;
            viewPager = itemView.findViewById(R.id.seckill);
            view_name = itemView.findViewById(R.id.view_name);
            view_logo = itemView.findViewById(R.id.view_logo);
            setData(resultBean.getDerive_info());
        }
        public void setData(final ResultBeanData.ResultBean.DeriveInfoBean drive_info){
            view_name.setText("设备 推荐");
            view_logo.setImageResource(R.mipmap.view_logo);
            actAdapter = new ActAdapter(context,drive_info.getList());
            viewPager.setAdapter(actAdapter);
            viewPager.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

            actAdapter.setOnSecKillRecylerView(new ActAdapter.OnActRecylerView() {
                @Override
                public void OnItemClick(int postion) {
                    ResultBeanData.ResultBean.DeriveInfoBean.ListBeanX listBean =
                            drive_info.getList().get(postion);
                    GoodsBean goodsBean = new GoodsBean();
                    goodsBean.setCover_price(listBean.getCover_price());
                    goodsBean.setName(listBean.getName());
                    goodsBean.setGoods_id(listBean.getProduct_id());
                    goodsBean.setFigure(listBean.getFigure());
                    goodsBean.setCall_to_buy(listBean.getCall_to_buy());
                    goodsBean.setSpecs(listBean.getSpecs());
                    goodsBean.setTaste(listBean.getTaste());
                    goodsBean.setDate_of_bad(listBean.getDate_of_bad());
                    goodsBean.setLogo(listBean.getLogo());
                    goodsBean.setProduct(listBean.getProduct());
                    goodsBean.setCompany_name(listBean.getCompany_name());
                    goodsBean.setCompany_logo(listBean.getCompany_logo());
                    goodsBean.setCompany_location(listBean.getCompany_location());
                    goodsBean.setCompany_people(listBean.getCompany_people());
                    goodsBean.setCompany_phone(listBean.getCompany_phone());
                    goodsBean.setCompany_info(listBean.getCompany_info());
                    startGoodsInfoActivity(goodsBean);
                    //Toast.makeText(context,"item : " + postion,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void startGoodsInfoActivity(GoodsBean goodsBean) {
        Intent intent = new Intent(context, GoodsInfo.class);
        intent.putExtra(GOODBEAN,goodsBean);
        context.startActivity(intent);
    }
    /**
     * 创建页面SecKillViewHolder
     * 初始化sec_kill_recview
     * 并在这里进行方法
     */
    class SecKillViewHolder extends RecyclerView.ViewHolder{

        private Context context;
        private RecyclerView recyclerView;
        private SecKillAdapter secKillAdapter;
        private TextView view_name;
        private ImageView view_logo;
        /*
        private TextView tv_time_seckill;
        private TextView tv_more_seckill;
        private long dt = 0;
        private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                dt = dt - 1000;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                String time =  simpleDateFormat.format(new Date(dt));
                tv_time_seckill.setText(time);
                handler.removeMessages(0);
                handler.sendEmptyMessageDelayed(0,1000);
                if (dt == 0){
                    handler.removeCallbacksAndMessages(null);
                }
            }

        };
        */
        public SecKillViewHolder(final Context context, View itemView) {
            super(itemView);
            this.context = context;
            recyclerView = itemView.findViewById(R.id.seckill);
            view_name = itemView.findViewById(R.id.view_name);
            view_logo = itemView.findViewById(R.id.view_logo);
//            tv_time_seckill = itemView.findViewById(R.id.tv_time_seckill);
//            tv_more_seckill = itemView.findViewById(R.id.tv_more_seckill);
            setData(resultBean.getDrinks_info());

        }

        @SuppressLint("WrongConstant")
        private void setData(final ResultBeanData.ResultBean.DrinksInfoBean drinks_info) {
            view_name.setText("饮品 推荐");
            view_logo.setImageResource(R.mipmap.view_logo_1);
            secKillAdapter = new SecKillAdapter(context,drinks_info.getList());
            recyclerView.setAdapter(secKillAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

            secKillAdapter.setOnSecKillRecylerView(new SecKillAdapter.OnSecKillRecylerView() {
                @Override
                public void OnItemClick(int postion) {
                    ResultBeanData.ResultBean.DrinksInfoBean.ListBean listBean =  drinks_info.getList().get(postion);
                   // ResultBeanData.ResultBean.ActInfoBean actInfoBean = seckill_info.get
                    GoodsBean goodsBean = new GoodsBean();
                    goodsBean.setCover_price(listBean.getCover_price());
                    goodsBean.setName(listBean.getName());
                    goodsBean.setGoods_id(listBean.getProduct_id());
                    goodsBean.setFigure(listBean.getFigure());
                    goodsBean.setCall_to_buy(listBean.getCall_to_buy());
                    goodsBean.setSpecs(listBean.getSpecs());
                    goodsBean.setTaste(listBean.getTaste());
                    goodsBean.setDate_of_bad(listBean.getDate_of_bad());
                    goodsBean.setLogo(listBean.getLogo());
                    goodsBean.setProduct(listBean.getProduct());
                    goodsBean.setCompany_name(listBean.getCompany_name());
                    goodsBean.setCompany_logo(listBean.getCompany_logo());
                    goodsBean.setCompany_location(listBean.getCompany_location());
                    goodsBean.setCompany_people(listBean.getCompany_people());
                    goodsBean.setCompany_phone(listBean.getCompany_phone());
                    goodsBean.setCompany_info(listBean.getCompany_info());
                    startGoodsInfoActivity(goodsBean);
                    //Toast.makeText(context,"item : " + postion,Toast.LENGTH_SHORT).show();
                }
            });
//            dt = Integer.valueOf(seckill_info.getStart_time()) - Integer.valueOf(seckill_info.getEnd_time());
//            handler.sendEmptyMessageDelayed(0,1000);
        }
    }

    private class RecomnendViewHolder extends  RecyclerView.ViewHolder {
        private Context context;
        private GridView gridView;
        private TextView tv_more_recommend;
        private RecomnendAdatper adatper;
        public RecomnendViewHolder(final Context context, View itemView) {
            super(itemView);
            this.context = context;
            gridView = itemView.findViewById(R.id.gv_recommend);
            gridView.setPadding(15,15,15,15);
            tv_more_recommend = itemView.findViewById(R.id.tv_more_recommend);


        }

        public void setData(final List<ResultBeanData.ResultBean.RecommendInfoBean> recommend_info) {
            adatper = new RecomnendAdatper(context,recommend_info);
            gridView.setAdapter(adatper);
            //ResultBeanData.ResultBean.RecommendInfoBean recommendInfoBean = resultBean.getRecommend_info().get(postion)


            //
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int position, long id) {

                    //Toast.makeText(context,"postion : " + position,Toast.LENGTH_SHORT).show();
                    ResultBeanData.ResultBean.RecommendInfoBean.InfoBean listBean = recommend_info.get(position).getInfo();
                    GoodsBean goodsBean = new GoodsBean();
                    goodsBean.setCover_price(listBean.getCover_price());
                    goodsBean.setName(listBean.getName());
                    goodsBean.setGoods_id(listBean.getProduct_id());
                    goodsBean.setFigure(listBean.getFigure());
                    goodsBean.setCall_to_buy(listBean.getCall_to_buy());
                    goodsBean.setSpecs(listBean.getSpecs());
                    goodsBean.setTaste(listBean.getTaste());
                    goodsBean.setDate_of_bad(listBean.getDate_of_bad());
                    goodsBean.setLogo(listBean.getLogo());
                    goodsBean.setProduct(listBean.getProduct());
                    goodsBean.setCompany_name(listBean.getCompany_name());
                    goodsBean.setCompany_logo(listBean.getCompany_logo());
                    goodsBean.setCompany_location(listBean.getCompany_location());
                    goodsBean.setCompany_people(listBean.getCompany_people());
                    goodsBean.setCompany_phone(listBean.getCompany_phone());
                    goodsBean.setCompany_info(listBean.getCompany_info());
                    startGoodsInfoActivity(goodsBean);
                }
            });
        }
    }


    /**
     * 得到类型
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType = BANNER;
                break;
            case CHANNEL:
                currentType = CHANNEL;
                break;
            case ACT:
                currentType = ACT;
                break;
            case SECKILL:
                currentType = SECKILL;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
            case HOT:
                currentType = HOT;
                break;
        }
        return currentType;
    }

    /**
     * 总共有多少个item
     * @return
     */
    @Override
    public int getItemCount() {
        //从1 ==>6
        return 5;
    }
    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load((String) path)
                    .into(imageView);
        }
    }


}
