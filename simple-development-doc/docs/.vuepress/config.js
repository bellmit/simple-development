// .vuepress/config.js
module.exports = {
    title: 'simple spring 中文文档',
    description: 'simple spring中文文档',
    // 注入到当前页面的 HTML <head> 中的标签
    head: [
        ['link', {rel: 'icon', href: '/favicon.ico'}], // 增加一个自定义的 favicon(网页标签的图标)
    ],
    markdown: {
        lineNumbers: true // 代码块显示行号
    },
    themeConfig: {
        smoothScroll: true,
        nav: [
            {text: 'Home', link: '/'},
            {text: 'github', link: 'https://github.com/likowong/simple-development'}
        ],
        sidebar: [
            {
                title: '简介',
                path: '/simpleDoc/simple/simple',
            },
            {
                title: '环境',
                path: '/simpleDoc/environment/environment',
            },
            {
                title: '快速入门',
                sidebarDepth: 7,    // 可选的, 默认值是 1
                path: "/simpleDoc/started/started",
                children: [
                    {title: "构建maven结构", path: "/simpleDoc/started/step1/step1"},
                    {title: "pom依赖", path: "/simpleDoc/started/step2/step2"},
                    {title: "配置文件", path: "/simpleDoc/started/step3/step3"},
                    {title: "环境隔离", path: "/simpleDoc/started/step4/step4"},
                    {title: "设置启动类", path: "/simpleDoc/started/step5/step5"},
                    {title: "自动生成代码", path: "/simpleDoc/started/step6/step6"},
                    {title: "打包", path: "/simpleDoc/started/step7/step7"}
                ]
            },
            {
                title: '整体设计',
                path: '/simpleDoc/design/design',
            },
            {
                title: '基础组件',
                path: '/simpleDoc/baseComponent/baseComponent',
                children: [
                    {title: "IsApiService", path: "/simpleDoc/baseComponent/step1/step1"},
                    {title: "SimpleInterceptor", path: "/simpleDoc/baseComponent/step2/step2"},
                    {title: "ValidHandler", path: "/simpleDoc/baseComponent/step3/step3"},
                    {title: "Value", path: "/simpleDoc/baseComponent/step4/step4"},
                    {title: "HasPermissions", path: "/simpleDoc/baseComponent/step5/step5"},
                    {title: "DataSource", path: "/simpleDoc/baseComponent/step6/step6"},
                    {title: "Idempotent", path: "/simpleDoc/baseComponent/step7/step7"},
                    {title: "tomcat", path: "/simpleDoc/baseComponent/step8/step8"},
                ]
            },
            {
                title: '高级组件',
                path: '/simpleDoc/advancedComponent/advancedComponent',
                children: [
                    {title: "SpringSimpleApplication", path: "/simpleDoc/advancedComponent/step1/step1"},
                    {title: "EnableWebMvc", path: "/simpleDoc/advancedComponent/step2/step2"},
                    {title: "EnableMybatis", path: "/simpleDoc/advancedComponent/step3/step3"},
                    {title: "EnableRedis", path: "/simpleDoc/advancedComponent/step4/step4"},
                    {title: "EnableXxlJob", path: "/simpleDoc/advancedComponent/step5/step5"},
                    {title: "EnableElasticSearch", path: "/simpleDoc/advancedComponent/step6/step6"},
                    {title: "EnableDubbo", path: "/simpleDoc/advancedComponent/step7/step7"},
                    {title: "EnableSwagger", path: "/simpleDoc/advancedComponent/step8/step8"},
                ]
            },
            {
                title: '系统参数说明',
                path: '/simpleDoc/configParam/configParam',
            },
            {
                title: '关于我们',
                path: '/simpleDoc/aboutus/aboutus',
            }
        ]
    }
}
