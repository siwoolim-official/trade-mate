'use client'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { ReactQueryDevtools } from '@tanstack/react-query-devtools' 
import { useState } from 'react'

export default function QueryPorvider({children}: {children: React.ReactNode}) {
    const [queryClient] = useState(() => new QueryClient({
        defaultOptions: {
            queries: {
                refetchOnWindowFocus: false, // 창이 다시 포커스될 때마다 쿼리를 다시 가져오지 않도록 설정
                retry: 1, // 쿼리가 실패했을 때 재시도 횟수 (0으로 설정하면 재시도하지 않음)
            },
        },
    }))

    return (
        <QueryClientProvider client={queryClient}>
            {children}
            <ReactQueryDevtools initialIsOpen={false} /> {/* 개발자 도구 추가 */}   
        </QueryClientProvider>
    )
}