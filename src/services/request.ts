const getParams = (params: any) => new URLSearchParams(params).toString();

const request = function (options: any) {
  return fetch(`${options.url}?${getParams(options.params)}`, options).then(
    (r) => r.json()
  );
};

const getUrl = (segments: any, url: urlType) =>
  typeof url === "string" ? url : url(segments);

export const GET =
  (url: urlType): any =>
  ({
    segments,
    params,
    body,
    headers = {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }: optionsType) =>
    request({
      params: params,
      body: body,
      headers: headers,
      method: "get",
      url: getUrl(segments, url),
    });
export const POST =
  (url: urlType): any =>
  ({
    segments,
    params,
    body,
    headers = {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }: optionsType) =>
    request({
      params: params,
      body: body,
      headers: headers,
      method: "post",
      url: getUrl(segments, url),
    });
export const PUT =
  (url: urlType): any =>
  (options: optionsType) =>
    request({ ...options, method: "put", url: getUrl(options.segments, url) });
export const DELETE =
  (url: urlType): any =>
  ({
    segments,
    params,
    body,
    headers = {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }: optionsType) =>
    request({
      params: params,
      body: body,
      headers: headers,
      method: "delete",
      url: getUrl(segments, url),
    });

type urlFnType = (v: any) => string;
type urlType = string | urlFnType;

type optionsType = {
  url?: string;
  segments?: any;
  params?: any;
  body?: any;
  headers?: any;
};
