import type { Metadata } from "next";
import {Inter} from "next/font/google";
import "./globals.css";
import QueryProvider from "@/components/providers/QueryProvider";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
    title: "Tread Meta - 주식일지 시스템",
    description: "나만의 정밀한 주식 매매일지 및 포트폴리오 관리",
};

export default function RootLayout({
    children,
}: {
    children: React.ReactNode;
}) {
    return (
        <html lang="ko">
            <body className={inter.className}>
                {/* tanstack query를 사용 */}
                <QueryProvider> 
                    {children}
                </QueryProvider>
            </body>
        </html>
    );
}