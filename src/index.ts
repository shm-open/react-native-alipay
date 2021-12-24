/* eslint-disable import/no-unused-modules */
import { NativeModules } from 'react-native';

type TStatus = '9000' | '8000' | '4000' | '5000' | '6001' | '6002';

export interface IResult {
    resultStatus: TStatus;
    result: string;
    memo: string;
}

export interface IResponse {
    resultCode: TStatus;
    returnUrl: string;
}

export function authWithInfo(infoStr: string): Promise<IResult> {
    return NativeModules.Alipay.authWithInfo(infoStr);
}

// 设置沙箱模式
export function setAlipaySandbox(isSandbox: boolean): void {
    return NativeModules.Alipay.setAlipaySandbox(isSandbox);
}

export function pay(infoStr: string): Promise<IResult> {
    return NativeModules.Alipay.pay(infoStr);
}

export function payInterceptorWithUrl(infoStr: string): Promise<IResponse> {
    return NativeModules.Alipay.payInterceptorWithUrl(infoStr);
}
