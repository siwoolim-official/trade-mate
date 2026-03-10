import type { Config } from "tailwindcss"

const config: Config = {
    // tailwind가 적용될 파일 경로
    content: [
        "/src/pages/**/*.{js,ts,jsx,tsx,mdx}",
        "/src/components/**/*.{js,ts,jsx,tsx,mdx}", // components 폴더 내의 모든 파일을 포함
        "/src/app/**/*.{js,ts,jsx,tsx,mdx}", 
    ],
    theme: {
        // tailwind의 기본 스타일을 확장할 때 사용
        extend: {},
    },
    plugins: [],
}

export default config